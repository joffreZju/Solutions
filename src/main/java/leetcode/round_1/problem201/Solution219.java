package leetcode.round_1.problem201;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joffre on 2017/11/29.
 * 219. Contains Duplicate II
 */
public class Solution219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - 1 - k]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 1, 5}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 1, 5}, 4));
        System.out.println(containsNearbyDuplicate(new int[]{0, 1, 2, 3, 4, 1, 5}, 5));
    }
}
