package leetcode.problem701;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 748. Shortest Completing Word
 */
public class Solution748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        int resIndex = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= minLen) continue;

            Map<Character, Integer> tmp = new HashMap<>(map);
            for (char c : words[i].toCharArray()) {
                if (tmp.containsKey(c)) {
                    if (tmp.get(c) > 1) tmp.put(c, tmp.get(c) - 1);
                    else tmp.remove(c);
                }
            }
            if (tmp.size() == 0) {
                resIndex = i;
                minLen = words[i].length();
            }
        }
        return words[resIndex];
    }

    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
