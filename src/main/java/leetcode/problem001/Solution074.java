package leetcode.problem001;

/**
 * Created by joffre on 2017/10/27.
 * 74. Search a 2D Matrix
 */
public class Solution074 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target == matrix[mid][0]) return true;
            else if (target < matrix[mid][0]) j = mid - 1;
            else if (target > matrix[mid][n - 1]) i = mid + 1;
            else i = j = mid;
        }
        int row = (i + j) / 2;
        i = 0;
        j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == matrix[row][mid]) return true;
            else if (target > matrix[row][mid]) i = mid + 1;
            else j = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
        System.out.println(searchMatrix(new int[][]{{1}}, 2));
    }
}
