package leetcode.problem201;

import java.util.*;

/**
 * Created by joffre on 2017/11/29.
 * 217. Contains Duplicate
 */
public class Solution217 {
    public static boolean containsDuplicate(int[] nums) {
        // int[] new_nums = Arrays.stream(nums).distinct().toArray();
        // return new_nums.length != nums.length;
        // Set set = IntStream.of(nums).boxed().collect(Collectors.toSet());
        // return set.size() != nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 1}));
    }
}
