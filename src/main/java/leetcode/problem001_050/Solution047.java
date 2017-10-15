package leetcode.problem001_050;

import java.util.*;

/**
 * Created by joffre on 2017/10/12.
 * 47. Permutations II
 */
public class Solution047 {
    //too slow
    // private static List<List<Integer>> res;
    // private static int len;
    //
    // public static List<List<Integer>> permuteUnique(int[] nums) {
    //     res = new ArrayList<>();
    //     len = nums.length;
    //     List<Integer> tmp = new ArrayList<>();
    //     Map<Integer, Integer> countMap = new HashMap<>();
    //     for (int i = 0; i < len; i++) {
    //         if (countMap.containsKey(nums[i])) {
    //             countMap.put(nums[i], countMap.get(nums[i]) + 1);
    //         } else {
    //             countMap.put(nums[i], 1);
    //         }
    //     }
    //     dfs(countMap.keySet(), tmp, countMap);
    //     return res;
    // }
    //
    // private static void dfs(Set<Integer> numsUnique, List<Integer> tmp, Map<Integer, Integer> countMap) {
    //     if (tmp.size() == len) {
    //         res.add(new ArrayList<>(tmp));
    //     } else {
    //         for (Integer num : numsUnique) {
    //             int rest = countMap.get(num);
    //             if (rest == 0) continue;
    //             countMap.replace(num, rest - 1);
    //             tmp.add(num);
    //             dfs(numsUnique, tmp, countMap);
    //             tmp.remove(tmp.size() - 1);
    //             countMap.replace(num, rest);
    //         }
    //     }
    // }



    private static List<List<Integer>> res;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        dfs(nums, tmp, used);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> tmp, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                //!used[i-1]: 在上一层递归中，如果nums[i-1]没有被选用，那么这一层nums[i]也不选用，直接continue。
                //因为在此处选用nums[i] 和 nums[i-1] 是一样的，而nums[i-1]一定已经被选用过了，所以这里会产生重复结果。

                if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
                if (used[i]) continue;
                tmp.add(nums[i]);
                used[i] = true;
                dfs(nums, tmp, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
