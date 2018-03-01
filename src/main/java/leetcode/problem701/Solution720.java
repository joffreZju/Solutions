package leetcode.problem701;

import java.util.*;

/**
 * 720. Longest Word in Dictionary
 */
public class Solution720 {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isLeaf;
        int freq;           //该字串的重复数目,频数
        int prefix_num;     //以该子串为前缀的单词数

        TrieNode() {
            this.children = new HashMap<>();
            this.isLeaf = false;
        }
    }

    private static TrieNode root;

    private static void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
    }

    private static boolean check(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.children.get(c);
            if (!cur.isLeaf) {
                return false;
            }
        }
        return true;
    }

    public static String longestWord(String[] words) {
        root = new TrieNode();
        for (String w : words) insert(w);

        String ans = "";
        for (String tmp : words) {
            if (check(tmp)) {
                if (tmp.length() > ans.length() || (tmp.length() == ans.length() && tmp.compareTo(ans) < 0)) {
                    ans = tmp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }
}
