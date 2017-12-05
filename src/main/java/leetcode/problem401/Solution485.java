package leetcode.problem401;

/**
 * 485. Max Consecutive Ones
 */
public class Solution485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 1, 1, 0, 1, 1, 1, 0, 0, 1}));
    }
}
