package leetcode.problem001_050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joffre on 2017/10/12.
 * 39. Combination Sum
 * DFS 回溯剪枝
 */
public class Solution039 {
    private static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        search(candidates, target, 0, tmp);
        return res;
    }

    private static void search(int[] candidates, int target, int start, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) return;
                tmp.add(candidates[i]);
                search(candidates, target - candidates[i], i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}
