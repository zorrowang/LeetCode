package src.java.easy.stream;

import java.util.LinkedList;

public class MovingAverage {
    long sum;
    LinkedList<Integer> queue;
    int size;

    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        // write your code here
        if (queue.size() == size)
            sum -= queue.poll();
        queue.offer(val);
        sum += val;
        return (double)sum/queue.size();
    }
}

class MovingAverage2 {
    LinkedList<Integer> queue;
    int size;
    double avg;
    /*
    * @param size: An integer
    */public MovingAverage2(int size) {
        // do initialization if necessary
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        if(queue.size()<this.size){
            queue.offer(val);
            int sum=0;
            for(int i: queue){
                sum+=i;
            }
            avg = (double)sum/queue.size();
 
            return avg;
        }else{
            int head = queue.poll();
            double minus = (double)head/this.size;
            queue.offer(val);
            double add = (double)val/this.size;
            avg = avg + add - minus;
            return avg;
        }
    }
}