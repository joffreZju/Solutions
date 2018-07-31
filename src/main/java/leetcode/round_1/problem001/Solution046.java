package leetcode.round_1.problem001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joffre on 2017/10/12.
 * 46. Permutations
 */
public class Solution046 {
    private static List<List<Integer>> res;

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] exists = new boolean[nums.length];
        Arrays.fill(exists, false);
        dfs(nums, tmp, exists);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> tmp, boolean[] exists) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (exists[i]) {
                    continue;
                }
                tmp.add(nums[i]);
                exists[i] = true;
                dfs(nums, tmp, exists);
                tmp.remove(tmp.size() - 1);
                exists[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{1}));
    }
}
