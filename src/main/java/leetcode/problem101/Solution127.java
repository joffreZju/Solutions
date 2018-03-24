package leetcode.problem101;

import java.util.*;

/**
 * 127. Word Ladder
 */
public class Solution127 {
    // Two-end BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        HashSet<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            level++;
            if (beginSet.size() > endSet.size()) {
                HashSet<String> ss = beginSet;
                beginSet = endSet;
                endSet = ss;
            }

            HashSet<String> tmp = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        // if (c == old) continue; 可以用 visited 替代
                        chars[j] = c;
                        String mod = String.valueOf(chars);
                        if (endSet.contains(mod)) return level;
                        if (set.contains(mod) && !visited.contains(mod)) {
                            tmp.add(mod);
                            visited.add(mod);
                        }
                    }
                    chars[j] = old;
                }
            }
            beginSet = tmp;
        }
        return 0;
    }

    // BFS
    // public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     Queue<String> queue = new LinkedList<>();
    //     HashSet<String> set = new HashSet<>(wordList);
    //     queue.offer(beginWord);
    //     int level = 1;
    //     while (!queue.isEmpty()) {
    //         level++;
    //         if (level > wordList.size() + 1) break;
    //
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             char[] chars = queue.poll().toCharArray();
    //
    //             for (int j = 0; j < chars.length; j++) {
    //                 char old = chars[j];
    //                 for (char c = 'a'; c <= 'z'; c++) {
    //                     chars[j] = c;
    //                     String mod = String.valueOf(chars);
    //                     if (set.contains(mod)) {
    //                         if (mod.equals(endWord)) return level;
    //                         queue.offer(mod);
    //                         set.remove(mod); // 已经用过的单词后面不可以再次使用，防止循环递归。
    //                     }
    //                 }
    //                 chars[j] = old;
    //             }
    //         }
    //     }
    //     return 0;
    // }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}
