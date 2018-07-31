package leetcode.round_1.problem101;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        int res = 0;
        // 用两个循环避免并发修改的多线程问题
        while (!set.isEmpty()) {
            for (int cur : set) {
                res = Math.max(res, dfs(cur, set));
                break;
            }
        }
        return res;
    }

    private int dfs(int cur, Set<Integer> set) {
        if (!set.contains(cur)) {
            return 0;
        }
        set.remove(cur);
        int left = 0, right = 0;
        if (set.contains(cur - 1)) left = dfs(cur - 1, set);
        if (set.contains(cur + 1)) right = dfs(cur + 1, set);
        return 1 + left + right;
    }
}
