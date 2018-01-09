package leetcode.problem201;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 */
public class Trie {
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

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children.containsKey(c)) cur = cur.children.get(c);
            else return false;
        }
        return cur.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children.containsKey(c)) cur = cur.children.get(c);
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();

        for (String word : "Your Trie object will be instantiated and called as such".split(" ")) obj.insert(word);

        System.out.println(obj.search("will"));
        System.out.println(obj.search("cal"));

        System.out.println(obj.startsWith("wil"));
        System.out.println(obj.startsWith("obj"));
        System.out.println(obj.startsWith("willing"));

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */