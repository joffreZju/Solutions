package leetcode.problem601;

/**
 * 695. Max Area of Island
 */
public class Solution695 {
    private static int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int i, int j) {
        int sum = 1;
        grid[i][j] = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) sum += dfs(grid, i - 1, j);
        if (i + 1 < m && grid[i + 1][j] == 1) sum += dfs(grid, i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == 1) sum += dfs(grid, i, j - 1);
        if (j + 1 < n && grid[i][j + 1] == 1) sum += dfs(grid, i, j + 1);
        return sum;
    }

}
