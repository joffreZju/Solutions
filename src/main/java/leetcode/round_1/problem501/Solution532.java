package leetcode.round_1.problem501;

import java.util.*;

/**
 * 532. K-diff Pairs in an Array
 */
public class Solution532 {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int index = Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k);
            if (index > 0) count++;

            // int left = i + 1, right = nums.length - 1, mid;
            // while (left <= right) {
            //     mid = (left + right) / 2;
            //     if (nums[i] + k == nums[mid]) {
            //         count++;
            //         break;
            //     } else if (nums[i] + k < nums[mid]) {
            //         right = mid - 1;
            //     } else {
            //         left = mid + 1;
            //     }
            // }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    }

    /**
     * 560. Subarray Sum Equals K
     */
    public static class Solution560 {
        public static int subarraySum(int[] nums, int k) {
            if (nums.length == 0) return 0;
            Map<Integer, List<Integer>> location = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0) nums[i] += nums[i - 1];
                List<Integer> locs;
                if (location.containsKey(nums[i])) locs = location.get(nums[i]);
                else locs = new ArrayList<>();
                locs.add(i);
                location.put(nums[i], locs);
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == k) res++;
                if (location.containsKey(nums[i] - k)) {
                    List<Integer> locs = location.get(nums[i] - k);
                    for (int loc : locs) {
                        if (loc < i) res++;
                        else break;
                    }
                }
            }
            return res;
        }

        public static int subarraySumAgain(int[] nums, int k) {
            if (nums.length == 0) return 0;
            Map<Integer, Integer> sumCount = new HashMap<>();
            sumCount.put(0, 1);
            int res = 0, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sumCount.containsKey(sum - k)) {
                    res += sumCount.get(sum - k);
                }
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
            System.out.println(subarraySumAgain(new int[]{1, 1, 1}, 2));
        }
    }
}
