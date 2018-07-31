package leetcode.round_1.problem601;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs
 */
public class MapSum {
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

    public MapSum() {
        root = new TrieNode();
    }

    private void insert(String word, int val) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
        cur.freq = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return sumFreq(cur);
    }

    private static int sumFreq(TrieNode root) {
        if (root == null) return 0;
        int sumTmp = 0;
        if (root.isLeaf) sumTmp += root.freq;
        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            sumTmp += sumFreq(entry.getValue());
        }
        return sumTmp;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
        System.out.println(mapSum.sum("aa"));
        mapSum.insert("aaa", 3);
        System.out.println(mapSum.sum("aaa"));
        System.out.println(mapSum.sum("bbb"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
