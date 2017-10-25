package leetcode.problem051_100;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/16.
 * 59. Spiral Matrix II
 */
public class Solution059 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int a = 0, b = n - 1, c = 0, d = n - 1, count = 1;
        while (true) {
            for (int i = a; i <= b; i++) {
                res[c][i] = count++;
            }
            c++;
            for (int i = c; i <= d; i++) {
                res[i][b] = count++;
            }
            b--;
            for (int i = b; i >= a; i--) {
                res[d][i] = count++;
            }
            d--;
            for (int i = d; i >= c; i--) {
                res[i][a] = count++;
            }
            a++;
            if (count > n * n) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] res = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
