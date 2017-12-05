package leetcode.problem001;

/**
 * Created by joffre on 2017/10/19.
 * 69. Sqrt(x)
 */
public class Solution069 {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long i = 1, j = x / 2, res = 1;
        while (i <= j) {
            long mid = (i + j) / 2;
            if (mid * mid <= x) {
                res = mid;
                i = mid + 1;
            } else {
                res = mid - 1;
                j = mid - 1;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(6));
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
    }
}
