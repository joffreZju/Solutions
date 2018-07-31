package leetcode.round_1.problem001;

/**
 * Created by joffre on 2017/10/17.
 * 63. Unique Paths II
 */
public class Solution063 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                // dp[i][n - 1] = 0;
                break;
            } else {
                dp[i][n - 1] = dp[i + 1][n - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                // dp[m - 1][i] = 0;
                break;
            } else {
                dp[m - 1][i] = dp[m - 1][i + 1];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}, {0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}, {1}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}, {0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}}));
    }
}
