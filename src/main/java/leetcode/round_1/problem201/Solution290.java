package leetcode.round_1.problem201;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 */
public class Solution290 {
    public static boolean wordPattern(String pattern, String str) {
        String[] splits = str.split(" ");
        if (splits.length != pattern.length()) return false;

        Map<String, Integer> splitMap = new HashMap<>();
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < splits.length; i++) {
            if (!splitMap.getOrDefault(splits[i], 0).equals(patternMap.getOrDefault(pattern.charAt(i), 0))) {
                return false;
            }
            splitMap.put(splits[i], i + 1);
            patternMap.put(pattern.charAt(i), i + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        // System.out.println(wordPattern("abba", "dog cat cat dog"));
        // System.out.println(wordPattern("abba", "dog dog dog dog"));
        // System.out.println(wordPattern("abba", "dog cat cat fish"));
        // System.out.println(wordPattern("aaaa", "dog cat cat dog"));

        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern, str));
    }
}
