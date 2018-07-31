package leetcode.round_1.problem201;

/**
 * 198. House Robber II
 */
public class Solution213 {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		else if (nums.length == 1) return nums[0];
		else if (nums.length == 2) return Math.max(nums[0], nums[1]);
		
		return Math.max(robFrom(nums, 0, nums.length - 1), robFrom(nums, 1, nums.length));
	}
	
	private static int robFrom(int[] nums, int start, int end) {
		// dp[i] 表示在nums[start-i]上偷得的最大金额。
		int len = end - start;
		if (len < 2) return 0;
		
		int[] dp = new int[len];
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start + 1]);
		
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
		}
		return dp[len - 1];
	}
}
