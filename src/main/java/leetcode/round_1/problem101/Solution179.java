package leetcode.round_1.problem101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 179. Largest Number
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int i : nums) strs.add(String.valueOf(i));
        strs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
