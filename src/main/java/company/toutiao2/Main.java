package company.toutiao2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(
				//				System.in
				"6 3\n" +
						"a\n" +
						"bc\n" +
						"d\n" +
						"eba\n" +
						"ebc\n" +
						"f\n" +
						"\n" +
						"yuklx\n" +
						"bcc\n" +
						"ff\n" +
						"\n" +
						"7 3\n" +
						"a\n" +
						"bc\n" +
						"d\n" +
						"eba\n" +
						"ebc\n" +
						"f\n" +
						"你好\n" +
						"\n" +
						"ebcc\n" +
						"你好吗\n" +
						"ebd\n" +
						"\n" +
						"6 2\n" +
						"a\n" +
						"bc\n" +
						"d\n" +
						"eba\n" +
						"ebc\n" +
						"f\n" +
						"\n" +
						"yuklx\n" +
						"bcc\n");
		
		while (in.hasNext()) {
			handle(in);
			if (in.hasNext()) {
				String t = in.nextLine();
				System.out.println();
				System.out.println();
			}
		}
	}
	
	public static void handle(Scanner in) {
		Trie trie = new Trie();
		int m = in.nextInt(), n = in.nextInt();
		for (int i = 0; i < m; i++) {
			trie.insert(in.next());
		}
		String tmp = in.nextLine();
		for (int i = 0; i < n; i++) {
			if (trie.search(in.next())) {
				System.out.print(1);
			} else {
				System.out.print(-1);
			}
			if (i < n - 1) System.out.println();
		}
	}
}

class Trie {
	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean isLeaf;
		
		TrieNode() {
			this.children = new HashMap<>();
			this.isLeaf = false;
		}
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
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
	
	public boolean search(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children.containsKey(c)) {
				cur = cur.children.get(c);
				if (cur.isLeaf) return true;
			} else return false;
		}
		return false;
	}
}