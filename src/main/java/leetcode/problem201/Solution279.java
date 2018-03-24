package leetcode.problem201;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. Perfect Squares
 */
public class Solution279 {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i <= n) squares.add(i * i);
        }

        int[] dp = new int[n + 1]; // dp[i]表示i分割成的平方数最小数目
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MIN_VALUE;
            for (int sq : squares) {
                if (sq > i) break;
                min = Math.min(min, dp[i - sq] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    // 优化
    // public int numSquares(int n) {
    //     int[] nums = new int[n + 1];
    //     nums[0] = 0;
    //     for (int i = 1; i <= n; i++) {
    //         // Use local variable.
    //         // Don't use nums[i]. It will cause cache miss and reduce the performance.
    //         int min = Integer.MAX_VALUE;
    //         for (int j = 1; j * j <= i; j++) {
    //             min = Math.min(min, 1 + nums[i - j * j]);
    //         }
    //         nums[i] = min;
    //     }
    //     return nums[n];
    // }
}
