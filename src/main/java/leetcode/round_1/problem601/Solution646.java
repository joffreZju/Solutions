package leetcode.round_1.problem601;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        // dp优化
        int max = 1, preEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > preEnd) {
                max++;
                preEnd = pairs[i][1];
            }
        }
        return max;

        // dp 思想
        // int[] dp = new int[pairs.length];
        // dp[0] = 1;
        // int preEnd = pairs[0][1];
        // for (int i = 1; i < pairs.length; i++) {
        //     if (pairs[i][0] > preEnd) {
        //         dp[i] = dp[i - 1] + 1;
        //         preEnd = pairs[i][1];
        //     } else dp[i] = dp[i - 1];
        // }
        // return dp[pairs.length - 1];
    }
}
