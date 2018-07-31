package leetcode.round_1.problem301;

/**
 * 303. Range Sum Query - Immutable
 */
public class NumArray {
    private static int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        if (nums.length == 0) return;
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (preSum.length == 0) return 0;
        else if (i == 0) return preSum[j];
        else return preSum[j] - preSum[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
