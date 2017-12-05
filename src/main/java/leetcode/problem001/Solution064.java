package leetcode.problem001;

/**
 * Created by joffre on 2017/10/18.
 * 64. Minimum Path Sum
 */
public class Solution064 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = m - 2; i >= 0; i--) {
            grid[i][n - 1] += grid[i + 1][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            grid[m - 1][i] += grid[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{0}}));
    }
}
