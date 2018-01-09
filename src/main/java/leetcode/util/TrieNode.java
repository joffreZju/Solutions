package leetcode.util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isLeaf;
    public int freq;           //该字串的重复数目,频数
    public int prefix_num;     //以该子串为前缀的单词数

    public TrieNode() {
        this.children = new HashMap<>();
        this.isLeaf = false;
    }
}
