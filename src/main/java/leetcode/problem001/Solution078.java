package leetcode.problem001;

import java.util.*;

/**
 * Created by joffre on 2017/10/28.
 * 78. Subsets
 */
public class Solution078 {
    private static List<List<Integer>> res;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, tmp);
        res.add(new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, int start, List<Integer> tmp) {
        if (tmp.size() != 0) res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
