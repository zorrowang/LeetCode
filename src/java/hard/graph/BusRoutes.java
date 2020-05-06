package src.java.hard.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
    class Graph {
        private int numVertices;
        private LinkedList<Integer>[] adjLists;

        Graph(int vertices) {
            numVertices = vertices;
            adjLists = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++)
                adjLists[i] = new LinkedList<>();
        }

        void addEdge(int src, int dst) {
            if (!adjLists[src].contains(dst))
                adjLists[src].add(dst);
        }
        
        public int shortestPath(int src, int dst) {
            // return shortestPathDfs(src, dst, 1, new boolean[numVertices]);
            return shortestPathBfs(src, dst);
        }
        
        private int shortestPathDfs(int src, int dst, int n, boolean[] visited) {
            if (src == dst)
                return n;
            LinkedList<Integer> neighbors = adjLists[src];
            int ret = Integer.MAX_VALUE;
            for (Integer v: neighbors) {
                if (visited[v])     continue;
                visited[v] = true;
                int t = shortestPathDfs(v, dst, n+1, visited);
                visited[v] = false;
                ret = Math.min(ret, t);
            }
            return ret;
        }
        
        private int shortestPathBfs(int src, int dst) {
            boolean visited[] = new boolean[numVertices];
            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            
            visited[src]=true;
            queue.add(src);
            int ret = 1;

            while (queue.size() != 0){
                int s = queue.poll();
                if (s == dst)   return ret;
                Iterator<Integer> i = adjLists[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        temp.add(n);
                    }
                }
                if (queue.isEmpty()) {
                    queue = temp;
                    temp = new LinkedList<>();
                    ret++;
                }
            }
            return Integer.MAX_VALUE;
        }
    }
        
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        int r = routes.length;
        Graph g = new Graph(r);
        Map<Integer, HashSet<Integer>> stopToRoute = new HashMap<>();
        // build map from stop to routes
        for (int i=0; i<r; i++) {
            for (int j=0; j<routes[i].length; j++) {
                if (!stopToRoute.containsKey(routes[i][j]))
                    stopToRoute.put(routes[i][j], new HashSet<>());
                stopToRoute.get(routes[i][j]).add(i);
            }
        }
        // build group of routes
        for (Integer stop: stopToRoute.keySet()) {
            Set<Integer> routeSet = stopToRoute.get(stop);
            for (Integer i: routeSet) {
                for (Integer j: routeSet) {
                    if (!i.equals(j))
                        g.addEdge(i, j);
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        Set<Integer> startRoutes = stopToRoute.get(S);
        Set<Integer> endRoutes = stopToRoute.get(T);
        for (Integer i: startRoutes) {
            for (Integer j: endRoutes) {
                ret = Math.min(ret, g.shortestPath(i, j));
            }
        }
        return ret == Integer.MAX_VALUE ? -1:ret;
    }
}