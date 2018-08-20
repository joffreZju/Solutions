package leetcode.round_2.problem101;

/**
 * 200. Number of Islands
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static int[] dx = new int[]{1, -1, 0, 0}, dy = new int[]{0, 0, -1, 1};

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
    }
}
