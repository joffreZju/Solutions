package leetcode.round_1.problem701;

/**
 * 724. Find Pivot Index
 */
public class Solution724 {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int i : nums) sum += i;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (leftSum == sum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
