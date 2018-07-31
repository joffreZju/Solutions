package leetcode.round_1.problem701;

import java.util.*;

/**
 * 763. Partition Labels
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() == 0) return res;

        int rightPos[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            rightPos[S.charAt(i) - 'a'] = i;
        }

        int pre = -1, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, rightPos[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - pre);
                pre = i;
            }
        }
        return res;
    }
}
