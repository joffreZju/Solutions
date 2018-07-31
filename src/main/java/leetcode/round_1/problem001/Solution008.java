package leetcode.round_1.problem001;

/**
 * Created by joffre on 2017/9/25.
 * 8. String to Integer(atoi)
 */
public class Solution008 {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        int res = 0, begin = 0;
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            begin = 1;
        } else if (str.charAt(0) == '+') {
            begin = 1;
        }
        int i = begin;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            res = res * 10 + (str.charAt(i++) - '0');
        }
        if (negative) {
            return 0 - res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Solution008.myAtoi("+"));
        System.out.println(Solution008.myAtoi("-"));
        System.out.println(Solution008.myAtoi("-1"));
        System.out.println(Solution008.myAtoi("0"));
        System.out.println(Solution008.myAtoi("1"));
        System.out.println(Solution008.myAtoi("+1"));
        System.out.println(Solution008.myAtoi("123"));
        System.out.println(Solution008.myAtoi("     +123a67"));
        System.out.println(Solution008.myAtoi("-123a     "));
        System.out.println(Solution008.myAtoi("2147483647"));
        System.out.println(Solution008.myAtoi("2147483648"));
        System.out.println(Solution008.myAtoi("-2147483648"));
        System.out.println(Solution008.myAtoi("-2147483649"));
    }
}
