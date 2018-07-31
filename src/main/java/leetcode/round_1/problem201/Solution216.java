package leetcode.round_1.problem201;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffre on 2017/11/29.
 * 216. Combination Sum III
 */
public class Solution216 {
    private static List<List<Integer>> res;
    private static int N;
    private static int K;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        N = n;
        K = k;
        dfs(1, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(int begin, int sum, List<Integer> tmp) {
        if (sum == N && tmp.size() == K) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; sum + i <= N && i < 10; i++) {
            tmp.add(i);
            sum += i;
            dfs(i + 1, sum, tmp);
            tmp.remove(tmp.size() - 1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
}
