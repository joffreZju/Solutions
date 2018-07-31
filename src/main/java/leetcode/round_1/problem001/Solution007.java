package leetcode.round_1.problem001;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffre on 2017/9/14.
 * Reverse Integer
 */
public class Solution007 {
    public int reverse(int x) {
        List<Integer> bits = new ArrayList<>();
        while (x != 0) {
            bits.add(x % 10); // -123 % 10 = -3
            x /= 10;
        }
        int len = bits.size();
        long res = 0;
        for (Integer bit : bits) {
            res += bit * (long) Math.pow(10, --len);
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution007().reverse(-123));
        System.out.println(new Solution007().reverse(10));
    }

}
