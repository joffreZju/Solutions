package leetcode.problem001_050;

/**
 * Created by joffre on 2017/10/13.
 * 50. Pow(x, n)
 */
public class Solution050 {
    public static double myPow(double x, long n) {
        if (x == 1 || x == 0) {
            return x;
        } else if (n == 0) {
            return 1;
        } else if (n > 0) {
            if (n % 2 != 0) {
                return x * myPow(x, n - 1);
            } else {
                return myPow(x * x, n / 2);
            }
        } else {
            return 1.0 / myPow(x, 0 - n);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, Integer.MAX_VALUE));
        System.out.println(myPow(8.84372, -5));

        System.out.println(Math.pow(8.84372, -5));
        System.out.println(Math.pow(2.0, Integer.MAX_VALUE));
    }
}
