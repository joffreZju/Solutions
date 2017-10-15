package leetcode.problem001_050;

/**
 * Created by joffre on 2017/9/30.
 * 29. Divide Two Integers
 */
public class Solution029 {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sign = -1;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            sign = 1;
        }
        long res = longDivide(Math.abs((long) dividend), Math.abs((long) divisor));
        if (sign < 0) {
            res = 0 - res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    private static long longDivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long tmpDivisor = divisor;
        long count = 1;
        while (dividend >= tmpDivisor + tmpDivisor) {
            tmpDivisor += tmpDivisor;
            count += count;
        }
        return count + longDivide(dividend - tmpDivisor, divisor);
    }

    public static void main(String[] args) {
        System.out.println(Solution029.divide(4, 2));
        System.out.println(Solution029.divide(-1, 1));
        System.out.println(Solution029.divide(3, -2));
        System.out.println(Solution029.divide(-5, -3));
        System.out.println(Solution029.divide(Integer.MAX_VALUE, 1));

        //overflow
        System.out.println(Solution029.divide(Integer.MIN_VALUE, -1));
        System.out.println(Solution029.divide(Integer.MIN_VALUE, 1));

        System.out.println(Solution029.divide(4, 2) == (4 / 2));
        System.out.println(Solution029.divide(-1, 1) == (-1 / 1));
        System.out.println(Solution029.divide(3, -2) == (3 / -2));
        System.out.println(Solution029.divide(-5, -3) == (-5 / -3));
        System.out.println(Solution029.divide(Integer.MAX_VALUE, -1) == (Integer.MAX_VALUE / -1));

    }
}
