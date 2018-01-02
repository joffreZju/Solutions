package leetcode.problem201;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    private static boolean helper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i), ti = t.charAt(i);
            if (!map.containsKey(si)) {
                if (map.containsValue(ti)) return false;
                map.put(si, ti);
            } else if (map.get(si) != ti) return false;
        }
        return true;
    }
}
