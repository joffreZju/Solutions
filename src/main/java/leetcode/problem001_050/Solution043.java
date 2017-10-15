package leetcode.problem001_050;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/12.
 * 43. Multiply Strings
 * 1、将手算结果存储在一个二维矩阵中（注意每一次存储列都要前移一个位置），下标倒序。
 * 2、倒序遍历每一列求和并进位，将每一位结果存入StringBuilder。
 * 3、移除leading zero
 *
 * 可以将二维数组压缩成一维！
 */
public class Solution043 {
    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length(), i, j;
        int[][] matrix = new int[len2][len1 + len2];

        for (i = 0; i < len2; i++) {
            Arrays.fill(matrix[i], 0);
        }

        for (i = len2 - 1; i >= 0; i--) {
            int cur, carry = 0;
            for (j = len1 - 1; j >= 0; j--) {
                cur = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                matrix[i][i + j + 1] = (cur + carry) % 10;// len1 + len2 - (len1 - j) - (len2 - 1 - i) = i + j + 1
                carry = (cur + carry) / 10;
            }
            if (carry != 0) matrix[i][i + j + 1] = carry;
        }

        int carry = 0;
        for (j = len1 + len2 - 1; j >= 0; j--) {
            int sum = 0;
            for (i = len2 - 1; i >= 0; i--) {
                sum += matrix[i][j];
            }
            sb.insert(0, (sum + carry) % 10);
            carry = (sum + carry) / 10;
        }
        if (carry != 0) sb.insert(0, carry);

        int count = 0;
        for (int k = 0; k < sb.length(); k++) {
            if (k != sb.length() - 1 && sb.charAt(k) == '0') {
                count++;
            } else {
                break;
            }
        }
        return sb.delete(0, count).toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("100", "0"));
        System.out.println(multiply("0", "110"));
        System.out.println(multiply("11", "11"));
        System.out.println(multiply("9", "9"));
    }
}
