package leetcode.problem001;

import java.util.*;

/**
 * Created by joffre on 2017/10/15.
 * 54. Spiral Matrix
 */
public class Solution054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        } else if (matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length, way = 0, i = 0, j = 0;
        boolean[][] visited = new boolean[m][n];
        while (!visited[i][j]) {
            res.add(matrix[i][j]);
            visited[i][j] = true;
            int[] next = nextLocation(way, i, j);
            if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n || visited[next[0]][next[1]]) {
                way++;
                way %= 4;
                next = nextLocation(way, i, j);
            }
            if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n) break;
            i = next[0];
            j = next[1];
        }
        return res;
    }

    private static int[] nextLocation(int way, int i, int j) {
        int[] res = new int[]{i, j};
        if (way == 0) {
            res[1]++;
        } else if (way == 1) {
            res[0]++;
        } else if (way == 2) {
            res[1]--;
        } else {
            res[0]--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
