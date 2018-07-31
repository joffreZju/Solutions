package leetcode.round_1.problem801;

public class Solution829 {
    public static int consecutiveNumbersSum(int n) {
        int res = 0;
        for (int i = 2; n / i >= i / 2; i++) {
            int mid = n / i, left, right = mid + i / 2;
            if (i % 2 == 0) {
                left = mid - i / 2 + 1;
            } else {
                left = mid - i / 2;
            }
            if (left <= 0) break;
            if (n == (left + right) * i / 2) res++;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(3));
        System.out.println(consecutiveNumbersSum(5));
        System.out.println(consecutiveNumbersSum(9));
        System.out.println(consecutiveNumbersSum(15));
    }
}
