package leetcode.round_1.problem201;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 */
public class Solution220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove((long) nums[i - k - 1]);
            long n = nums[i];
            Long ceiling = set.ceiling(n), floor = set.floor(n);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
}
