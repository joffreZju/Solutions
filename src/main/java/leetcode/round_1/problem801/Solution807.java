package leetcode.round_1.problem801;

/**
 * 807 Max Increase to Keep City Skyline
 */
public class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxx = new int[n], maxy = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxx[i] = Math.max(grid[i][j], maxx[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxy[i] = Math.max(grid[j][i], maxy[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(maxx[i], maxy[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
