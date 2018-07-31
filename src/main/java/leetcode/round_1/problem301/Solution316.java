package leetcode.round_1.problem301;

import java.util.Arrays;
import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 */
public class Solution316 {
    public static String removeDuplicateLetters(String s) {
        int counter[] = new int[26];
        boolean chosen[] = new boolean[26];
        for (char c : s.toCharArray()) counter[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter[c - 'a']--;
            // 当前字符已经在栈中
            if (chosen[c - 'a']) continue;

            int len;
            // 如果当前字符比栈顶的字符小，且栈顶的字符后面还会出现，那么将其出栈，修改 chosen 标记
            while ((len = sb.length()) > 0 && c < sb.charAt(len - 1) && counter[sb.charAt(len - 1) - 'a'] > 0) {
                chosen[sb.charAt(len - 1) - 'a'] = false;
                sb.delete(len - 1, len);
            }

            // 将当前字符入栈
            sb.append(c);
            chosen[c - 'a'] = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
