package leetcode.problem001_100;

/**
 * Created by joffre on 2017/9/18.
 * 28. Implement strStr()
 */
public class Solution028 {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (i - 1 + needle.length() >= haystack.length()) {
                return index;
            }
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            index = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(index + j) != needle.charAt(j)) {
                    index = -1;
                    break;
                }
                if (j == needle.length() - 1) {
                    return index;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String hayStack = "wangjunfujum", needle = "jum";
        System.out.println(strStr(needle, hayStack));
    }
}
