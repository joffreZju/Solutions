package leetcode.problem051_100;

/**
 * Created by joffre on 2017/10/27.
 * 73. Set Matrix Zeroes
 */
public class Solution073 {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstColunm = false;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) firstRow = true;
                    if (j == 0) firstColunm = true;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;

        if (firstRow)
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;

        if (firstColunm)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }

}
