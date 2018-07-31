package leetcode.round_1.problem501;

import java.util.Arrays;

/**
 * 561. Array Partition I
 */
public class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) count += nums[i];
        return count;
    }
}
