package leetcode.problem401;

import java.util.HashSet;
import java.util.Set;

/**
 * 494. Target Sum
 */
public class Solution494 {
	/**
	 * 题解：https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation/160162
	 * sum(P) - sum(N) = target
	 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
	 * 2 * sum(P) = target + sum(nums)
	 */
	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
	}
	
	private int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}
	
	// DFS
	//	public int findTargetSumWays(int[] nums, int S) {
	//		int len = nums.length;
	//		// sets[i] 记录了从 i~len-1 有多少种 sum 结果，辅助 dfs 快速失败
	//		Set<Integer>[] sets = new Set[len];
	//		sets[len - 1] = new HashSet<>();
	//		sets[len - 1].add(nums[len - 1]);
	//		sets[len - 1].add(-nums[len - 1]);
	//
	//		for (int i = len - 2; i >= 0; i--) {
	//			sets[i] = new HashSet<>();
	//			for (int t : sets[i + 1]) {
	//				sets[i].add(t + nums[i]);
	//				sets[i].add(t - nums[i]);
	//			}
	//		}
	//
	//		counter = 0;
	//		dfs(nums, S, 0, 0, sets);
	//		return counter;
	//	}
	//
	//	private int counter;
	//
	//	private void dfs(int[] nums, int S, int cur, int start, Set[] sets) {
	//		if (start == nums.length) {
	//			if (cur == S) counter++;
	//			return;
	//		}
	//		if (!sets[start].contains(S - cur)) return;
	//
	//		dfs(nums, S, cur + nums[start], start + 1, sets);
	//		dfs(nums, S, cur - nums[start], start + 1, sets);
	//	}
}
