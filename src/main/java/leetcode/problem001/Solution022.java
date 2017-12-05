package leetcode.problem001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by joffre on 2017/9/30.
 * 22. Generate Parentheses
 */
public class Solution022 {
    public static List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        if (n == 0) {
            return new ArrayList<>(res);
        } else if (n == 1) {
            res.add("()");
            return new ArrayList<>(res);
        } else {
            List<String> resPre = generateParenthesis(n - 1);
            for (int i = 0; i < resPre.size(); i++) {
                for (int j = 0; j < 2 * (n - 1); j++) {
                    StringBuilder sb = new StringBuilder(resPre.get(i));
                    sb.insert(j, "()");
                    res.add(sb.toString());
                }
            }
            return new ArrayList<>(res);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution022.generateParenthesis(3));
    }
}
