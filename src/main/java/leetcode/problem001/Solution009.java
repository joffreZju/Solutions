package leetcode.problem001;

/**
 * Created by joffre on 2017/9/14.
 * Palindrome Number
 */
public class Solution009 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int left, right = 0;
        for (int i = 0; ; i++) {
            if (x / (int) Math.pow(10, i) < 10) {
                left = i;
                break;
            }
        }
        while (left > right) {
            int l = x / (int) Math.pow(10, left) % 10;
            int r = x % (int) Math.pow(10, right + 1) / (int) Math.pow(10, right);
            if (l != r) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution009 solution009 = new Solution009();
        System.out.println(solution009.isPalindrome(-11));
        System.out.println(solution009.isPalindrome(1));
        System.out.println(solution009.isPalindrome(11));
        System.out.println(solution009.isPalindrome(121));
        System.out.println(solution009.isPalindrome(1221));
        System.out.println(solution009.isPalindrome(100021));
    }
}
