package leetcode.round_1.problem001;

import java.util.*;

/**
 * Created by joffre on 2017/9/29.
 * 17. Letter Combinations of a Phone Number
 */
public class Solution017 {
    //递归
    public static List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('0', Arrays.asList(" "));
        map.put('1', new ArrayList<>());
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        int len = digits.length();
        if (len == 0) {
            return new ArrayList<>();
        } else if (len == 1) {
            List<String> res = new ArrayList<>();
            for (String s : map.get(digits.charAt(0))) {
                res.add(s);
            }
            return res;
        } else {
            List<String> res = new ArrayList<>();
            for (String str : letterCombinations(digits.substring(0, len - 1)))
                for (String s : map.get(digits.charAt(len - 1)))
                    res.add(str + s);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution017.letterCombinations("234"));
    }
}
