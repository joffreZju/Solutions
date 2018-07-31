package leetcode.round_1.problem301;

/**
 * 329. Longest Increasing Path in a Matrix
 */
public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int max = 1, rows = matrix.length, cols = matrix[0].length;
        int counter[][] = new int[rows][cols];
        boolean visited[][] = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, counter, visited, i, j));
            }
        }
        return max;
    }

    private static int[] shiftX = new int[]{0, 1, 0, -1};
    private static int[] shiftY = new int[]{1, 0, -1, 0};


    private int dfs(int[][] matrix, int[][] counter, boolean[][] visited, int i, int j) {
        if (counter[i][j] != 0) return counter[i][j];

        visited[i][j] = true;
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            int x = i + shiftX[k], y = j + shiftY[k];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y]) continue;

            if (matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, counter, visited, x, y));
            }
        }

        visited[i][j] = false;
        counter[i][j] = Math.max(max + 1, 1);
        return counter[i][j];
    }
}
