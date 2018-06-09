package leetcode.problem201;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 */
public class Solution239 {
    // 滑动窗口
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;

        int res[] = new int[nums.length - k + 1], maxIdx = getMaxIdx(nums, 0, k - 1);

        for (int i = k; i < nums.length; i++) {
            res[i - k] = nums[maxIdx];
            if (nums[i] > nums[maxIdx]) maxIdx = i;
            else if (maxIdx == i - k) maxIdx = getMaxIdx(nums, maxIdx + 1, i);
        }
        res[res.length - 1] = nums[maxIdx];

        return res;
    }

    private int getMaxIdx(int[] nums, int sta, int end) {
        int ans = sta;
        for (int i = sta + 1; i <= end; i++) {
            if (nums[i] >= nums[ans]) ans = i;
        }
        return ans;
    }

    // 优先队列 O(N*logK)
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums.length == 0 || k < 1) return new int[0];
    //
    //     PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
    //         @Override
    //         public int compare(Integer o1, Integer o2) {
    //             return o2 - o1;
    //         }
    //     });
    //     int res[] = new int[nums.length - k + 1], j = 0;
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         if (queue.size() < k) queue.offer(nums[i]);
    //         else {
    //             res[j++] = queue.peek();
    //             queue.remove(nums[i - k]);
    //             queue.offer(nums[i]);
    //         }
    //     }
    //     res[j] = queue.peek();
    //     return res;
    // }
}
