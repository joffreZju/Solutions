package leetcode.problem201;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */
public class MedianFinder {
    private PriorityQueue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek()) {
            left.offer(num);
            if (left.size() - right.size() > 1) {
                right.offer(left.poll());
            }
        } else {
            right.offer(num);
            if (right.size() - left.size() > 1) {
                left.offer(right.poll());
            }
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) return left.peek();
        else if (right.size() > left.size()) return right.peek();
        return (left.peek() + right.peek()) / 2.0;
    }
}
