package leetcode.round_2.problem001;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class Solution054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length, size = m * n;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (res.size() < size) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            if (res.size() == size) break;

            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (res.size() == size) break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            if (res.size() == size) break;

            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
