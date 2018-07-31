package leetcode.round_1.problem001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by joffre on 2017/9/30.
 * 22. Generate Parentheses
 */
public class Solution022 {
    // Solution2
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), 0, n, res);
        return res;
    }

    private static void dfs(StringBuilder sb, int left, int n, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        int right = sb.length() - left;
        if (left < n) {
            sb.append('(');
            dfs(sb, left + 1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(sb, left, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Solution1
    // public static List<String> generateParenthesis(int n) {
    //     Set<String> res = new HashSet<>();
    //     if (n == 0) {
    //         return new ArrayList<>(res);
    //     } else if (n == 1) {
    //         res.add("()");
    //         return new ArrayList<>(res);
    //     } else {
    //         List<String> resPre = generateParenthesis(n - 1);
    //         for (int i = 0; i < resPre.size(); i++) {
    //             for (int j = 0; j < 2 * (n - 1); j++) {
    //                 StringBuilder sb = new StringBuilder(resPre.get(i));
    //                 sb.insert(j, "()");
    //                 res.add(sb.toString());
    //             }
    //         }
    //         return new ArrayList<>(res);
    //     }
    // }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
