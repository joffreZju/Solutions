package leetcode.problem401;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution480 {
    private PriorityQueue<Integer> left, right;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return null;

        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
        int j = 0, len = nums.length;
        double[] res = new double[len - k + 1];
        for (int i = 0; i < len; i++) {
            if (i < k) addToWindow(nums[i]);
            else if (nums[i] != nums[i - k]) {
                removeFromWindow(nums[i - k]);
                addToWindow(nums[i]);
            }
            if (left.size() + right.size() >= k) {
                res[j++] = getCurMedian();
            }
        }
        return res;
    }

    private void addToWindow(int num) {
        if (left.isEmpty() || num < left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        adjust();
    }

    private void removeFromWindow(int num) {
        if (!left.remove(num)) right.remove(num);
        adjust();
    }

    private void adjust() {
        if (left.size() - right.size() > 1) {
            right.offer(left.poll());
        } else if (right.size() - left.size() > 1) {
            left.offer(right.poll());
        }
    }

    private double getCurMedian() {
        if (left.size() > right.size()) return left.peek();
        else if (right.size() > left.size()) return right.peek();
        return ((double) left.peek() + right.peek()) / 2.0;
    }
}
