package leetcode.problem401;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 */
public class Solution416 {
    // dp：空间 O(sum / 2)
    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for (int num : nums) sum += num;
    //     if (sum % 2 != 0) return false;
    //
    //     int half = sum / 2;
    //     boolean dp[] = new boolean[half + 1];
    //     for (int num : nums) {
    //         for (int i = half - num; i >= 0; i--) { // i--, 否则会将 num 重复使用
    //             if (dp[i]) dp[i + num] = true;
    //         }
    //         if (num <= half) dp[num] = true; // 先更新 dp[i + num], 再更新 dp[num]
    //     }
    //     return dp[half];
    // }

    //递归，非常优秀！
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        Arrays.sort(nums);
        sum /= 2;
        return helper(nums, sum, 0, 0, nums.length - 1);
    }

    private boolean helper(int[] nums, int sum, int p1, int p2, int index) {
        if (p1 > sum || p2 > sum) return false;
        if (index == -1) {
            if (p1 == sum && p2 == sum) return true;
            return false;
        }
        // 对于 nums[index], 仅有两种情况：分配给 p1 或 p2, 分别递归即可
        return (helper(nums, sum, p1 + nums[index], p2, index - 1) ||
                helper(nums, sum, p1, p2 + nums[index], index - 1));
    }
}
