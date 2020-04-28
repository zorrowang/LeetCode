package src.java.medium.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        LinkedList<Integer> sIndex = new LinkedList<>();
        
        for(int i=0; i<T.length; i++) {
            while(!sIndex.isEmpty() && T[sIndex.peek()]<T[i]) {
                int index = sIndex.pop();
                ret[index] = i-index;
            }
            sIndex.push(i);
        }
        return ret;
    }

    // Legacy Solution
    class Item {
        int temp;
        int pos;
        
        Item(int temp, int pos) {
            this.temp = temp;
            this.pos = pos;
        }
    }

    /**
     * @param temperatures: a list of daily temperatures
     * @return: a list of how many days you would have to wait until a warmer temperature
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        // Time Limit Exceeded
        PriorityQueue<Item> maxQueue = new PriorityQueue<>((x, y) -> y.temp - x.temp);
        int[] ret = new int[temperatures.length];
        for (int i=temperatures.length-1; i>=0; i--) {
            if (maxQueue.isEmpty() || maxQueue.peek().temp <= temperatures[i]) {
                maxQueue.offer(new Item(temperatures[i], i));
                ret[i] = 0;
            } else {
                ArrayList<Item> temp = new ArrayList<>();
                int min = Integer.MAX_VALUE;
                while (!maxQueue.isEmpty() && maxQueue.peek().temp > temperatures[i]) {
                    temp.add(maxQueue.poll());
                    min = Math.min(min, temp.get(temp.size()-1).pos);
                }
                ret[i] = min - i;
                for (int s=0; s<temp.size(); s++) {
                    maxQueue.offer(temp.get(s));
                }
                maxQueue.offer(new Item(temperatures[i], i));
            }
        }
        return ret;
    }
}