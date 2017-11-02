package leetcode.problem051_100;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/27.
 * 75. Sort Colors
 */
public class Solution075 {
    public static void sortColors(int[] nums) {
        int[] counter = new int[]{0, 0, 0};
        for (int i = 0; i < nums.length; i++) counter[nums[i]]++;

        int start = 0, end;
        for (int i = 0; i < 3; i++) {
            if (i != 0) start += counter[i - 1];
            end = start + counter[i];
            for (int j = start; j < end; j++) nums[j] = i;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 1, 1, 2, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
