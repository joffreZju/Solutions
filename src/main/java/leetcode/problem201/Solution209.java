package leetcode.problem201;

/**
 * Created by joffre on 2017/11/28.
 * 209. Minimum Size Subarray Sum
 */
public class Solution209 {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0, sum = 0, minlen = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                minlen = Math.min(j - i + 1, minlen);
                sum -= nums[i++];
            }
            j++;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
