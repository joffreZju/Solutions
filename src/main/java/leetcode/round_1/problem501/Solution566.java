package leetcode.round_1.problem501;

import java.util.Arrays;

/**
 * 566. Reshape the Matrix
 */
public class Solution566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] res = new int[r][c];
        int ii = 0, jj = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[ii][jj++] = nums[i][j];
                if (jj == c) {
                    ii++;
                    jj = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        int[][] res = matrixReshape(nums, 1, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

        res = matrixReshape(res, 2, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }
}
