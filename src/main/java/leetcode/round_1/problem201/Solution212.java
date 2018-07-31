package leetcode.round_1.problem201;

import java.util.*;

public class Solution212 {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isLeaf;

        public TrieNode() {
            children = new HashMap<>();
            isLeaf = false;
        }
    }

    private TrieNode root;

    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String word : words) insert(word);

        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, new StringBuilder(), res);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, TrieNode cur, StringBuilder sb, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') return;
        char c = board[i][j];
        board[i][j] = '#';
        sb.append(c);
        if (cur.children.containsKey(c)) {
            cur = cur.children.get(c);
            if (cur.isLeaf) {
                res.add(sb.toString());
            }
            dfs(board, i + 1, j, cur, sb, res);
            dfs(board, i - 1, j, cur, sb, res);
            dfs(board, i, j + 1, cur, sb, res);
            dfs(board, i, j - 1, cur, sb, res);
        }
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = c;
    }

}
