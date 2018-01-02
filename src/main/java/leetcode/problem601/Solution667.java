package leetcode.problem601;

import java.util.Arrays;

/**
 * 667. Beautiful Arrangement II
 *
 * 1~k+1个数之间可以构造出1~k个不等的距离
 * [1,k+1,2,k,3,k-1,...]刚好满足条件
 * 然后将剩余的k+2 ~ n按顺序放到数组的尾部
 */
public class Solution667 {
    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int num = 1;
        for (int i = 0; i < k + 1; i += 2) {
            res[i] = num++;
        }
        num = k + 1;
        for (int i = 1; i < k + 1; i += 2) {
            res[i] = num--;
        }
        num = k + 2;
        for (int i = k + 1; i < n; i++) {
            res[i] = num++;
        }
        return res;
    }

    public static int[] constructArrayAgain(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(3, 1)));
        System.out.println(Arrays.toString(constructArray(3, 2)));
        System.out.println(Arrays.toString(constructArray(10, 5)));
        System.out.println(Arrays.toString(constructArray(10, 6)));
        System.out.println(Arrays.toString(constructArrayAgain(10, 5)));
        System.out.println(Arrays.toString(constructArrayAgain(10, 6)));

    }
}
