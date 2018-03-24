package leetcode.problem101;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class Solution131 {
    private static List<List<String>> res;

    private static int[][] cache;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        cache = new int[s.length()][s.length()];
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(String s, int start, List<String> tmp) {
        if (start >= s.length()) res.add(new ArrayList<>(tmp));
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (cache[start][i] == 1 || isPalindrome(str)) {
                cache[start][i] = 1;
                tmp.add(str);
                dfs(s, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
