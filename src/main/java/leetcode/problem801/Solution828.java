package leetcode.problem801;

import java.util.*;

public class Solution828 {
    // 暴力，超时 TODO
    public static int uniqueLetterString(String s) {
        int n = s.length();
        if (n <= 1) return n;

        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> uniq = new HashSet<>(), dup = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (!dup.contains(c) && !uniq.contains(c)) {
                    uniq.add(c);
                } else {
                    uniq.remove(c);
                    dup.add(c);
                }
                res += uniq.size();
            }
        }
        return res % 1000_000_007;
    }

    public static void main(String[] args) {
        // System.out.println(uniqueLetterString("ABC"));
        // System.out.println(uniqueLetterString("ABA"));
        // System.out.println(uniqueLetterString("AAA"));
        // System.out.println(uniqueLetterString("BABABBABAA"));

        System.out.println("abcdef".hashCode());
    }
}
