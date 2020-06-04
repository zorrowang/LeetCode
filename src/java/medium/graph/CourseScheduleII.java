package src.java.medium.graph;

import java.util.LinkedList;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        int[] ret = new int[numCourses];
        
        for(int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            if (matrix[from][to] == 0)
                degree[to]++;
            matrix[from][to] = 1;
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i=0; i<numCourses; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int from = queue.poll();
            ret[count++] = from;
            for (int i=0; i<numCourses; i++) {
                if (matrix[from][i] == 1) {
                    degree[i]--;
                    if (degree[i]==0)
                        queue.offer(i);
                }
            }
        }
        return count==numCourses?ret:new int[0];
}