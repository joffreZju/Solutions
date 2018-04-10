package leetcode.problem601;

/**
 * 628. Maximum Product of Three Numbers
 */
public class Solution628 {
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1, 2, 3}));
        System.out.println(maximumProduct(new int[]{-1, 0, 2, 3}));
        System.out.println(maximumProduct(new int[]{-2, -1, 0, 2, 3}));
        System.out.println(maximumProduct(new int[]{-2, -2, 1, 2, 3}));
    }

}