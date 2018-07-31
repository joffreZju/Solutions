package leetcode.round_1.problem101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> once = new HashSet<>(), more = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (once.contains(sub)) {
                more.add(sub);
            } else {
                once.add(sub);
            }
        }
        return new ArrayList<>(more);
    }
}
