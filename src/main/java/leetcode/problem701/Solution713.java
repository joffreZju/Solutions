package leetcode.problem701;

/**
 * 713. Subarray Product Less Than K
 */
public class Solution713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int pro = 1, left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            pro *= nums[right];
            while (pro >= k && left <= right) {
                pro /= nums[left++];
            }
            count += right - left + 1;
            /**
             * 每次加入一个新的nums[right]
             * 然后右移left, 使得nums[left, right](inclusive)的product小于k
             * 此时最长的subArray: len = right - left + 1
             * 那么会有新的len个subArray加入结果集，这些subArray长度分别为1 ~ len (其中每一个subArray都包含nums[right])
             */
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
