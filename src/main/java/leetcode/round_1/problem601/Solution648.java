package leetcode.round_1.problem601;

import java.util.*;

/**
 * 648. Replace Words
 */
public class Solution648 {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isLeaf;
        int freq;           //该字串的重复数目,频数
        int prefixNum;     //以该子串为前缀的单词数

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

    private static String getShortestPrefix(String word) {
        TrieNode cur = root;
        int i;
        for (i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.isLeaf) break;

            if (cur.children.containsKey(c)) cur = cur.children.get(c);
            else return word;
        }
        return word.substring(0, i);
    }

    public static String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for (String d : dict) insert(d);
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            sb.append(getShortestPrefix(word)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    // 暴力
    public static String replaceWords__(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            String tmp = "";
            for (char c : chars) {
                tmp += String.valueOf(c);
                if (set.contains(tmp)) {
                    words[i] = tmp;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}
