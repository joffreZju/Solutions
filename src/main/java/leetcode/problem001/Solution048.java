package leetcode.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/13.
 * 48. Rotate Image
 * 先reverse，后对称
 * 1 2 3    3 2 1   7 4 1
 * 4 5 6    6 5 4   8 5 2
 * 7 8 9    9 8 7   9 6 3
 */
public class Solution048 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length, tmp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
