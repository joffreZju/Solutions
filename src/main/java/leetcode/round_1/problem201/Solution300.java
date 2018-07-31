package leetcode.round_1.problem201;

import java.util.*;

/**
 * 300. Longest Increasing Subsequence
 */
public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		if (nums.length <= 1) return nums.length;
		
		int n = nums.length;
		int res = Integer.MIN_VALUE;
		// list中保存一个递增子序列，每遇到一个元素，二分找到其插入位置，然后使用set()更新list，或者直接在尾部add()
		// 也可以用一个 int[nums.length] 来代替list。
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int low = 0, high = list.size() - 1;
			
			if (list.size() == 0 || (high >= 0 && nums[i] > list.get(high))) {
				list.add(nums[i]);
				res = list.size();
				continue;
			}
			
			while (low < high) {
				int mid = low + (high - low) / 2, v = list.get(mid);
				if (nums[i] < v) {
					high = mid;
				} else if (nums[i] > v) {
					low = mid + 1;
				} else {
					low = mid;
					high = mid;
				}
			}
			list.set(low, nums[i]);
		}
		return res;
	}
	
	//	DP O(n^2)
	//	public int lengthOfLIS(int[] nums) {
	//		if (nums.length <= 1) return nums.length;
	//
	//		int n = nums.length, dp[] = new int[n];
	//		dp[0] = 1;
	//		int res = Integer.MIN_VALUE;
	//
	//		for (int i = 1; i < n; i++) {
	//			for (int j = i - 1; j >= 0; j--) {
	//				if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]);
	//			}
	//			dp[i]++;
	//			res = Math.max(res, dp[i]);
	//		}
	//		return res;
	//	}
}
