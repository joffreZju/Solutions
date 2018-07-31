package leetcode.round_1.problem401;

/**
 * 463. Island Perimeter
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int cells = 0, neighbor = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cells++;
                    // 只看上方和前方的邻居，避免重复
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) neighbor++;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) neighbor++;
                }
            }
        }
        return cells * 4 - neighbor * 2;
    }
}
