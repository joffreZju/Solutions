package leetcode.problem001_100;

import java.util.*;

/**
 * Created by joffre on 2017/9/26.
 * 15.3Sum
 */
public class Solution015 {
    //超时
    // public static List<List<Integer>> threeSum(int[] nums) {
    //     Set<List<Integer>> res = new HashSet<>();
    //     Set<Integer> intIsExist = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         int target = nums[i];
    //         if (!intIsExist.contains(target)) {
    //             intIsExist.add(target);
    //         } else {
    //             continue;
    //         }
    //
    //         Map<Integer, Integer> location = new HashMap<>();
    //         for (int j = i + 1; j < nums.length; j++) {
    //
    //             if (location.containsKey(nums[j])) {
    //                 List<Integer> list = Arrays.asList(target, nums[j], location.get(nums[j]));
    //                 list.sort(Integer::compareTo);
    //                 res.add(list);
    //             } else {
    //                 location.put(0 - target - nums[j], nums[j]);
    //             }
    //         }
    //     }
    //     return new ArrayList<>(res);
    // }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i], left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(0 - target, nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;

                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution015.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(Solution015.threeSum(new int[]{0, 0, 0, 0}));
    }
}
