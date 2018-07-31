package leetcode.round_1.problem601;

import java.util.Arrays;

/**
 * 661. Image Smoother
 */
public class Solution661 {
    private static int m, n;

    public static int[][] imageSmoother(int[][] M) {
        m = M.length;
        n = M[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] |= smooth(M, i, j) << 8;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] >>= 8;
            }
        }
        return M;
    }

    private static int smooth(int[][] M, int i, int j) {
        int sum = 0, count = 0;
        for (int k = Math.max(0, i - 1); k <= Math.min(m - 1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(n - 1, j + 1); l++) {
                sum += M[k][l] & 0xFF;
                count++;
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        int a = 7;
        a |= a << 8;
        System.out.println(Integer.toBinaryString(a & 0xFF));

        int[][] matrix = new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        int[][] m = imageSmoother(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

}
