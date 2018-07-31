package leetcode.round_1.problem401;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array442. Find All Duplicates in an Array
 */
public class Solution442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            } else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) res.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 5, 1, 3, 2, 4}));
    }
}
