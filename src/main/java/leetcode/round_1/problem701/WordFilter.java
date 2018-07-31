package leetcode.round_1.problem701;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 745. Prefix and Suffix Search
 */
public class WordFilter {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        int weight;

        TrieNode() {
            this.children = new HashMap<>();
            this.weight = -1;
        }
    }

    private TrieNode root;

    public WordFilter(String[] words) {
        Set<String> tmp = new HashSet<>();
        root = new TrieNode();
        for (int i = words.length - 1; i >= 0; i--) {
            if (tmp.contains(words[i])) continue;
            else tmp.add(words[i]);

            // add these words to trie: '#apple', 'e#apple', 'le#apple', 'ple#apple', 'pple#apple', 'apple#apple'
            for (int j = words[i].length(); j >= 0; j--) {
                add(words[i].substring(j) + "#" + words[i], i);
            }
        }
    }

    private void add(String word, int weight) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.weight = weight;
    }

    private static Set<Integer> sumLeaf(TrieNode cur) {
        Set<Integer> set = new HashSet<>();
        if (cur.weight != -1) set.add(cur.weight);
        for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
            set.addAll(sumLeaf(entry.getValue()));
        }
        return set;
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = root;

        StringBuilder sb = new StringBuilder();
        for (char c : suffix.toCharArray()) sb.append(c);
        sb.append("#").append(prefix);

        for (char c : sb.toString().toCharArray()) {
            if (cur.children.get(c) == null) return -1;
            cur = cur.children.get(c);
        }

        int maxWeight = -1;
        for (int w : sumLeaf(cur)) maxWeight = Math.max(maxWeight, w);
        return maxWeight;
    }

    public static void main(String[] args) {
        // WordFilter filter = new WordFilter(new String[]{"apple", "aplle"});
        // System.out.println(filter.f("a", "e"));
        // System.out.println(filter.f("app", "le"));
        // System.out.println(filter.f("app", "ll"));

        WordFilter filter = new WordFilter(new String[]{"hwxekxrbst", "xtmkmgencg", "odsdjhjjkk", "wxaxuswqxc", "rmurhkmuze", "kgphhwokcm", "lvoapqeppp", "pcpsdhfcsh", "alztysttkq", "nhfttbpzwf"});
        System.out.println(filter.f("alztysttkq", "tkq"));
        System.out.println(filter.f("al", "ysttkq"));
        System.out.println(filter.f("rmurhkmuze", "rmurhkmuze"));
        System.out.println(filter.f("kg", "kgphhwokcm"));
        System.out.println(filter.f("nhfttbpzwf", "fttbpzwf"));
        System.out.println(filter.f("nhfttbpzwf", "fttbpzwf"));
        System.out.println(filter.f("xtmkmgencg", "mkmgencg"));
        System.out.println(filter.f("kgph", "hhwokcm"));
        System.out.println(filter.f("", "tysttkq"));
        System.out.println(filter.f("alztystt", ""));

        /**
         * 8
         * 8
         * 4
         * 5
         * 9
         * 9
         * 1
         * 5
         * 8
         * 8
         */
    }
}
