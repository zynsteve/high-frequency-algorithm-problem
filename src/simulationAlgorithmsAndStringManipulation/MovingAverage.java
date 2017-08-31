package simulationAlgorithmsAndStringManipulation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 * Example
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1 // return 1.00000
 * m.next(10) = (1 + 10) / 2 // return 5.50000
 * m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
 * m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 */

public class MovingAverage {
    Queue<Integer> queue;
    int capacity;
    double sum;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.capacity = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        if (queue.size() == capacity) {
            sum = sum - queue.poll();
        }
        queue.offer(val);
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */
