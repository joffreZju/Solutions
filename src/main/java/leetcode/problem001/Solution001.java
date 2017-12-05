package leetcode.problem001;

import java.util.Arrays;
import java.util.*;
import java.util.Map;

/**
 * Created by joffre on 2017/8/29.
 * Two Sum
 */
public class Solution001 {
    //    暴力
    // public int[] twoSum(int[] nums, int target) {
    //     int[] res = new int[2];
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums.length; j++) {
    //             if (i == j) {
    //                 continue;
    //             }
    //             if (nums[i] + nums[j] == target) {
    //                 res[0] = i < j ? i : j;
    //                 res[1] = i > j ? i : j;
    //             }
    //         }
    //     }
    //     return res;
    // }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                res[0] = map.get(target - num);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        System.out.println(Arrays.toString(solution001.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
