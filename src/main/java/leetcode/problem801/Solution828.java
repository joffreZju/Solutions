package leetcode.problem801;

import java.util.*;

public class Solution828 {
    /**
     * https://leetcode.com/problems/unique-letter-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand
     */
    public static int uniqueLetterString(String S) {
        if (S == null || S.length() == 0) return 0;
        int res = 0, cur = 0;
        int contribution[] = new int[128], showLastPosition[] = new int[128];
        Arrays.fill(showLastPosition, -1);

        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);

            cur -= contribution[x]; // 先减去 x 在 cur[i - 1] 的贡献
            contribution[x] = (i - showLastPosition[x]);
            cur += contribution[x]; // 再加上 x 在 cur[i] 的贡献

            showLastPosition[x] = i;
            res += cur;
        }
        return res;
    }

    // 暴力，超时
    // public static int uniqueLetterString(String s) {
    //     int n = s.length();
    //     if (n <= 1) return n;
    //
    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         Set<Character> uniq = new HashSet<>(), dup = new HashSet<>();
    //         for (int j = i; j < n; j++) {
    //             char c = s.charAt(j);
    //             if (!dup.contains(c) && !uniq.contains(c)) {
    //                 uniq.add(c);
    //             } else {
    //                 uniq.remove(c);
    //                 dup.add(c);
    //             }
    //             res += uniq.size();
    //         }
    //     }
    //     return res % 1000_000_007;
    // }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
        System.out.println(uniqueLetterString("ABA"));
        System.out.println(uniqueLetterString("AAA"));
        System.out.println(uniqueLetterString("BABABBABAA"));
    }
}
