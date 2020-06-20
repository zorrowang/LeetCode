package src.java.medium.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i=0; i<tickets.size(); i++)
            map.computeIfAbsent(tickets.get(i).get(0), 
                                t -> new PriorityQueue<>()).add(tickets.get(i).get(1));
        List<String> ret = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<>();
        stack.add("JFK");
        while(!stack.isEmpty()) {
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            ret.add(0, stack.pop());
        }
        return ret;
    }
}