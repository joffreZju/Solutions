package leetcode.problem801;

import java.util.*;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < s.length(); ) {
            int begin = i, end = begin;
            while (end < s.length() && s.charAt(end) == s.charAt(begin)) end++;
            if (end - begin >= 3) res.add(Arrays.asList(begin, end - 1));
            i = end;
        }
        return res;
    }
}