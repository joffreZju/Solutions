package leetcode.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/31.
 * 80. Remove Duplicates from Sorted Array II
 */
public class Solution080 {
    public static int removeDuplicates(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++)
            if (!(counter >= 2 && nums[i] == nums[counter - 1] && nums[i] == nums[counter - 2]))
                nums[counter++] = nums[i];

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4}));
        System.out.println(removeDuplicates(new int[]{}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{1, 1}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1}));
    }
}
