package leetcode.problem001;

/**
 * Created by joffre on 2017/10/18.
 * 67. Add Binary
 */
public class Solution067 {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int cur = carry;
            if (i >= 0) cur += (a.charAt(i--) - '0');
            if (j >= 0) cur += (b.charAt(j--) - '0');
            sb.insert(0, cur % 2);
            carry = cur / 2;
        }
        return sb.toString();
    }
}