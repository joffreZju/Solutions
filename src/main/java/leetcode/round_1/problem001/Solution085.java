package leetcode.round_1.problem001;

/**
 * 85. Maximal Rectangle
 */
public class Solution085 {
    // Solution1: BFS
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1') maxArea = Math.max(maxArea, BFS(matrix, i, j));
        return maxArea;
    }

    private int BFS(char[][] matrix, int r, int c) {
        int row = r - 1, maxArea = 0;
        while (row >= 0 && matrix[row][c] == '1') row--;
        for (int i = c; i >= 0 && matrix[r][i] == '1'; i--) {
            for (int j = row + 1; j <= r; j++)
                if (matrix[j][i] == '0') row = Math.max(row, j);
            maxArea = Math.max(maxArea, (r - row) * (c - i + 1));
        }
        return maxArea;
    }


    // Solution2: 基于 84. Largest Rectangle in Histogram
    // public int maximalRectangle(char[][] matrix) {
    //     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    //     int max = 0, m = matrix.length, n = matrix[0].length, heights[] = new int[n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == '0') heights[j] = 0;
    //             else heights[j]++;
    //         }
    //         max = Math.max(max, largestRectangleArea(heights));
    //     }
    //     return max;
    // }
    //
    //
    // private int largestRectangleArea(int[] heights) {
    //     if (heights == null || heights.length == 0) return 0;
    //     int n = heights.length, res = 0;
    //     int left[] = new int[n]; // left[i]: 从 i 向左第一个小于 heights[i] 的下标
    //     int right[] = new int[n]; // right[i]: 从 i 向右第一个小于 heights[i] 的下标
    //
    //     left[0] = -1;
    //     right[n - 1] = n;
    //
    //     for (int i = 1; i < n; i++) {
    //         int j = i - 1;
    //         while (j >= 0 && heights[j] >= heights[i]) j = left[j];// 这里是关键
    //         left[i] = j;
    //     }
    //     for (int i = n - 2; i >= 0; i--) {
    //         int j = i + 1;
    //         while (j < n && heights[j] >= heights[i]) j = right[j];// 这里是关键
    //         right[i] = j;
    //     }
    //     for (int i = 0; i < n; i++) {
    //         res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
    //     }
    //     return res;
    // }
}
