package leetcode.round_1.problem001;

import java.util.*;

/**
 * Created by joffre on 2017/10/28.
 * 77. Combinations
 */
public class Solution077 {
    private static List<List<Integer>> res;

    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(1, n, k, tmp);
        return res;
    }

    private static void dfs(int start, int n, int k, List<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i <= n; i++) {
                tmp.add(i);
                dfs(i + 1, n, k, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }


}
