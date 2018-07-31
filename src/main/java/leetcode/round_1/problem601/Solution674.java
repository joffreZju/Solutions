package leetcode.round_1.problem601;

/**
 * 674. Longest Continuous Increasing Subsequence
 */
public class Solution674 {
    public static int findLengthOfLCIS(int[] nums) {
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else count = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 2, 3, 2, 4}));
        System.out.println(findLengthOfLCIS(new int[]{1, 2, 2, 2, 4}));
        System.out.println(findLengthOfLCIS(new int[]{1, 1}));
        System.out.println(findLengthOfLCIS(new int[]{1}));
    }
}
