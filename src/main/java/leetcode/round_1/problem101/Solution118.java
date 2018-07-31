package leetcode.round_1.problem101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
118. Pascal's Triangle
 */
public class Solution118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(Arrays.asList(1));
        if (numRows == 1) return res;

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>(), pre = res.get(i - 1);
            tmp.add(1);
            for (int j = 1; j <= i; j++) {
                int left = pre.get(j - 1), right = 0;
                if (j < pre.size()) right = pre.get(j);
                tmp.add(left + right);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(6));
    }
}
