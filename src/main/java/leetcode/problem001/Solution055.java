package leetcode.problem001;

/**
 * Created by joffre on 2017/10/15.
 * 55. Jump Game
 */
public class Solution055 {
    //超时
    // public static boolean canJump(int[] nums) {
    //     return dfs(nums, 0);
    // }
    // private static boolean dfs(int[] nums, int pos) {
    //     if (pos == nums.length - 1) {
    //         return true;
    //     } else if (pos >= nums.length || nums[pos] == 0) {
    //         return false;
    //     } else {
    //         for (int i = nums[pos]; i >= 1; i--) {
    //             if (pos + i >= nums.length) continue;
    //             if (dfs(nums, pos + i)) return true;
    //         }
    //     }
    //     return false;
    // }

    // DP
    // public static boolean canJump(int[] nums) {
    //     int len = nums.length;
    //     boolean[] dp = new boolean[len];
    //     dp[len - 1] = true;
    //     int nearest = len - 1;
    //     for (int i = len - 2; i >= 0; i--) {
    //         if (nums[i] + i >= nearest) {
    //             dp[i] = true;
    //             nearest = i;
    //         }
    //     }
    //     return dp[0];
    // }

    public static boolean canJump(int[] nums) {
        int youCan = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= youCan) {
                youCan = i;
            }
        }
        return youCan == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 100, 2, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{0}));
    }
}
