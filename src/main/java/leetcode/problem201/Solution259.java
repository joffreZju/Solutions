package leetcode.problem201;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 */
public class Solution259 {
    public static int[] productExceptSelf(int[] nums) {
        int all = 1;
        int zeroCount = 0;
        for (int i : nums) {
            if (i == 0) zeroCount++;
            else all *= i;
        }
        if (zeroCount > 1) {
            Arrays.fill(nums, 0);
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) nums[i] = all;
                else nums[i] = 0;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = all / nums[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 1, 2, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0, 2, 3})));
    }
}
