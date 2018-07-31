package leetcode.problem201;

/**
 * 221. Maximal Square
 */
public class Solution221 {
    // X 处的最大矩形依赖于左 上 左上三个位置的结果, size[][] 可以优化为 pre[] 和 cur[] 两个一维数组
    // 1 1 1 1    1 1 1 0     0 1 1 1     0 0 0 0
    // 1 1 1 1    1 1 1 0     0 1 1 1     1 1 1 0
    // 1 1 1 1    1 1 1 0     0 1 1 1     1 1 1 0
    // 1 1 1 X    0 0 0 X     0 0 0 X     1 1 1 X
    // public int maximalSquare(char[][] matrix) {
    //     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    //     int m = matrix.length, n = matrix[0].length, max = 0, size[][] = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         size[i][0] = matrix[i][0] - '0';
    //         max = Math.max(max, size[i][0]);
    //     }
    //     for (int i = 0; i < n; i++) {
    //         size[0][i] = matrix[0][i] - '0';
    //         max = Math.max(max, size[0][i]);
    //     }
    //
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             if (matrix[i][j] == '1') {
    //                 size[i][j] = 1 + Math.min(size[i - 1][j - 1], Math.min(size[i - 1][j], size[i][j - 1]));
    //                 max = Math.max(max, size[i][j]);
    //             }
    //         }
    //     }
    //     return max * max;
    // }

    // 递归
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;
        for (int i = 0; i + max < m; i++) {
            for (int j = 0; j + max < n; j++) {
                if (matrix[i][j] == '1') max = Math.max(max, dfs(matrix, max, i, j));
            }
        }
        return max * max;
    }

    private int dfs(char[][] matrix, int max, int x, int y) {
        if (x + max >= matrix.length || y + max >= matrix[0].length) return 0;
        for (int i = x; i < x + max + 1; i++) {
            for (int j = y; j < y + max + 1; j++) {
                if (matrix[i][j] == '0') return 0;
            }
        }
        return Math.max(max + 1, dfs(matrix, max + 1, x, y));
    }
}
