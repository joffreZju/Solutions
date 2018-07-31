package leetcode.round_1.problem101;

/**
 * 198. House Robber
 */
public class Solution198 {
    // public int rob(int[] nums) {
    // 	if (nums.length == 0) return 0;
    // 	else if (nums.length == 1) return nums[0];
    //
    // 	// dp[i] 表示在nums[0-i]上偷得的最大金额。
    // 	int[] dp = new int[nums.length];
    // 	dp[0] = nums[0];
    // 	dp[1] = Math.max(nums[0], nums[1]);
    // 	for (int i = 2; i < nums.length; i++) {
    // 		dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    // 	}
    // 	return dp[dp.length - 1];
    // }

    // 优化O(1) space
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int[] dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i % 3] = Math.max(dp[(i - 1) % 3], dp[(i - 2) % 3] + nums[i]);
        }
        return dp[(nums.length - 1) % 3];
    }
}
