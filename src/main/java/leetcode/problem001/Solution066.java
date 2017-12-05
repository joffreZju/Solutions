package leetcode.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/18.
 * 66. Plus One
 */
public class Solution066 {
    public static int[] plusOne(int[] digits) {
        int head = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] %= 10;
                if (i == 0) {
                    head = 1;
                }
            }
        }
        if (head == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = head;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
