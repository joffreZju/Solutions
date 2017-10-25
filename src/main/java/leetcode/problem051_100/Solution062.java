package leetcode.problem051_100;

/**
 * Created by joffre on 2017/10/17.
 * 62. Unique Paths
 */
public class Solution062 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 2));
        System.out.println(uniquePaths(2, 1));
        System.out.println(uniquePaths(3, 7));
    }
}
