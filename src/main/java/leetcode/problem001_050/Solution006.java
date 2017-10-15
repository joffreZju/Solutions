package leetcode.problem001_050;

import java.util.Arrays;

/**
 * Created by joffre on 2017/9/23.
 * 6. ZigZag Conversion
 */
public class Solution006 {
    public static String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        //确定区块数目
        int len = s.length(), block = 0;
        while (len > 0) {
            len -= (numRows + numRows - 2);
            block++;
        }
        //确定二维矩阵行列数
        int row = numRows, column = block * (numRows - 1);
        char[][] matrix = new char[row][column];
        for (int i = 0; i < row; i++) {
            Arrays.fill(matrix[i], '-');
        }
        // 将char按序播种到二维矩阵上
        int r = 0, c = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            matrix[r][c] = s.charAt(i);
            if (down) {
                r++;
            } else {
                c++;
                r--;
            }
            if (r == row - 1) {
                down = false;
            } else if (r == 0) {
                down = true;
            }
        }
        // 遍历二维矩阵得到结论
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] != '-') {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("A", 1));
    }
}
