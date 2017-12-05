package leetcode.problem001;

/**
 * Created by joffre on 2017/9/17.
 * 14. Longest Common Prefix
 */
public class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
                    return sb.toString();
                }
            }
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
