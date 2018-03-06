package leetcode.problem001;

import java.util.*;

/* 90. Subsets II
 */
public class Solution090 {
	private static List<List<Integer>> res;
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		res = new ArrayList<>();
		Arrays.sort(nums);//没有sort会重复
		res.add(new ArrayList<>());
		dfs(nums, 0, new ArrayList<>());
		return res;
	}
	
	private static void dfs(int[] nums, int start, List<Integer> tmp) {
		if (tmp.size() != 0) res.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i - 1]) continue;
			tmp.add(nums[i]);
			dfs(nums, i + 1, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{2, 2, 1, 2}));
    }

}
