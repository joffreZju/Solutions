package leetcode.round_1.problem101;

import java.util.*;

/**
 * 140. Word Break II
 */

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = 0, len = s.length();
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
        }
        List<String> res = dfs(set, s, 0, maxLen, new int[len], new HashMap<>());
        if (res == null) return new ArrayList<>();
        else return res;
    }

    /**
     * 可以直接把 canBreak 省略掉，用cache.put(i, null) 表示不可切分。
     * @param set 字典集合
     * @param s 字符串
     * @param start 起始index
     * @param maxLen 字典里面的单词最大长度，用于剪枝，切分出的单词长度不会超过maxLen
     * @param canBreak canBreak[i] 表示 i ~ len 已经被 dfs 处理过，可以进行切分，同时 cache 里面已经存有切分结果
     * @param cache cache 是 dfs结果的缓存，cache[i] 表示 i ~ len 的切分结果
     * @return 返回的时候，同时更新 canBreak 和 cache
     */
    private List<String> dfs(Set<String> set, String s, int start, int maxLen, int[] canBreak, Map<Integer, List<String>> cache) {
        if (start >= s.length()) return new ArrayList<>();
        if (canBreak[start] == -1) return null;
        if (canBreak[start] == 1) return cache.get(start);

        List<String> cur = new ArrayList<>();
        for (int i = start + 1; i - start <= maxLen && i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) {
                List<String> post = dfs(set, s, i, maxLen, canBreak, cache);
                if (post == null) {
                    continue;
                } else if (post.size() == 0) {
                    cur.add(s.substring(start, i));
                } else if (post.size() > 0) {
                    for (String t : post) cur.add(s.substring(start, i) + " " + t);
                }
            }
        }
        if (cur.size() == 0) {
            canBreak[start] = -1;
            return null;
        } else {
            canBreak[start] = 1;
            cache.put(start, cur);
            return cur;
        }
    }
}
