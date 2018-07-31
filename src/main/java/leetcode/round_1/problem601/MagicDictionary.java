package leetcode.round_1.problem601;

import java.util.*;

/**
 * 676. Implement Magic Dictionary
 */
public class MagicDictionary {
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

    private static boolean searchFromCur(TrieNode cur, String word) {
        for (char c : word.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return false;
        }
        return cur.isLeaf;
    }

    private static TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) insert(word);
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length() && cur != null; i++) {
            // word[0:i]匹配
            // word[i]不匹配
            // word[i + 1:]匹配
            for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
                if (entry.getKey().equals(word.charAt(i))) continue;
                if (searchFromCur(entry.getValue(), word.substring(i + 1))) return true;
            }
            cur = cur.children.get(word.charAt(i));
        }
        return false;
    }

    // solve with hashSet
    // private static Set<String> set;
    //
    // public MagicDictionary() {
    //     set = new HashSet<>();
    // }
    //
    // public void buildDict(String[] dict) {
    //     for (String word : dict) {
    //         char[] chars = word.toCharArray();
    //         for (int i = 0; i < chars.length; i++) {
    //             char tmp = chars[i];
    //             for (char j = 'a'; j <= 'z'; j++) {
    //                 if (j != tmp) {
    //                     chars[i] = j;
    //                     set.add(String.valueOf(chars));
    //                 }
    //             }
    //             chars[i] = tmp;
    //         }
    //     }
    // }
    //
    // public boolean search(String word) {
    //     return set.contains(word);
    // }

    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();

        // dictionary.buildDict(new String[]{"hello", "hallo", "leetcode"});
        // System.out.println(dictionary.search("hello"));
        // System.out.println(dictionary.search("hhllo"));
        // System.out.println(dictionary.search("hhlle"));
        // System.out.println(dictionary.search("hell"));
        // System.out.println(dictionary.search("hellol"));
        // System.out.println(dictionary.search("abc"));

        dictionary.buildDict(new String[]{"a", "b", "ab", "abc", "abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj",
                "abcdefghijawefe", "aefawoifjowajfowafjeoawjfaow", "cba", "cas", "aaewfawi", "babcda", "bcd", "awefj"});
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search("b"));
        System.out.println(dictionary.search("c"));
        System.out.println(dictionary.search("d"));
        System.out.println(dictionary.search("e"));
        System.out.println(dictionary.search("f"));

        System.out.println(dictionary.search("ab"));

        System.out.println(dictionary.search("ba"));

        System.out.println(dictionary.search("abc"));
        System.out.println(dictionary.search("cba"));
        System.out.println(dictionary.search("abb"));
        System.out.println(dictionary.search("bb"));
        System.out.println(dictionary.search("aa"));
        System.out.println(dictionary.search("bbc"));

        System.out.println(dictionary.search("abcd"));
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.partMatch(word);
 */
