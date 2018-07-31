package leetcode.round_1.problem501;

import java.util.*;

/**
 * 524. Longest Word in Dictionary through Deleting
 */
public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (int idx = 0; idx < d.size(); idx++) {
            String t = d.get(idx);
            if (t.length() > s.length()) continue;

            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) j++;
                i++;
            }

            if (j == t.length()) {
                if (t.length() > res.length()) res = t;
                else if (t.length() == res.length() && t.compareTo(res) < 0) res = t;
            }
        }
        return res;
    }
}
