package leetcode.round_1.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/17.
 * 62. Unique Paths
 */
public class Solution062 {
    /**
     * 优化
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     * 只需要矩阵的上一个和前一个元素，所以将 m 行矩阵压平成 1 行，
     * 那么每一次更新 dp[j](dp[i][j]) = dp[j] (代替原来的dp[i-1][j]) + dp[j - 1] (dp[i][j-1]);
     */
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // public static int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         dp[i][0] = 1;
    //     }
    //     for (int i = 0; i < n; i++) {
    //         dp[0][i] = 1;
    //     }
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 2));
        System.out.println(uniquePaths(2, 1));
        System.out.println(uniquePaths(3, 7));
    }
}
