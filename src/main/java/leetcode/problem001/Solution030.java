package leetcode.problem001;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 */
public class Solution030 {
    // 滑动窗口
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return res;

        Map<String, Integer> needToFind = new HashMap<>(), hasFound = new HashMap<>();
        for (String w : words) needToFind.put(w, 1 + needToFind.getOrDefault(w, 0));

        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            int start = i;
            hasFound.clear();

            for (int end = start; end + len <= s.length(); ) {
                String cur = s.substring(end, end + len);
                end += len;

                if (!needToFind.containsKey(cur)) {
                    start = end;
                    hasFound.clear();
                } else {
                    hasFound.put(cur, 1 + hasFound.getOrDefault(cur, 0));
                    while (hasFound.get(cur) > needToFind.get(cur)) {
                        String left = s.substring(start, start + len);
                        hasFound.put(left, hasFound.get(left) - 1);
                        start += len;
                    }
                    if (end - start == words.length * len) {
                        res.add(start);
                        String left = s.substring(start, start + len);
                        hasFound.put(left, hasFound.get(left) - 1);
                        start += len;
                    }
                }
            }
        }
        return res;
    }

    // 暴力 AC
    // public List<Integer> findSubstring(String s, String[] words) {
    //     List<Integer> res = new ArrayList<>();
    //     if (words.length == 0 || s.length() == 0) return res;
    //
    //     Map<String, Integer> map = new HashMap<>(), tmp = new HashMap<>();
    //     for (String w : words) map.put(w, 1 + map.getOrDefault(w, 0));
    //
    //     int start = 0, wlen = words[0].length();
    //     while (start + wlen * words.length - 1 < s.length()) {
    //         tmp.clear();
    //         int i = start;
    //         while (i + wlen <= s.length()) {
    //             String sub = s.substring(i, i + wlen);
    //             if (map.containsKey(sub)) {
    //                 tmp.put(sub, 1 + tmp.getOrDefault(sub, 0));
    //                 if (tmp.get(sub) > map.get(sub)) break;
    //                 i += wlen;
    //             } else break;
    //         }
    //         if (i - start == wlen * words.length) res.add(start);
    //         start++;
    //     }
    //     return res;
    // }
}
