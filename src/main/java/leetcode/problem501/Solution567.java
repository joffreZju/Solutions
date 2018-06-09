package leetcode.problem501;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 */
public class Solution567 {
    private static boolean allZeros(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int map[] = new int[26];
        for (int i = 0; i < len1; i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        if (allZeros(map)) return true;

        for (int i = len1; i < len2; i++) {
            map[s2.charAt(i) - 'a']--;
            map[s2.charAt(i - len1) - 'a']++;
            if (allZeros(map)) return true;
        }
        return false;
    }


    // 双指针扫描
    // public static boolean checkInclusion(String s1, String s2) {
    //     if (s1.length() > s2.length()) return false;
    //
    //     Map<Character, Integer> map = new HashMap<>(), tmp;
    //     for (char c : s1.toCharArray()) {
    //         map.put(c, 1 + map.getOrDefault(c, 0));
    //     }
    //
    //     tmp = new HashMap<>(map);
    //     int count = s1.length(), left = 0;
    //     for (int right = 0; right < s2.length(); right++) {
    //         char c = s2.charAt(right);
    //
    //         if (!tmp.containsKey(c)) {
    //             tmp = new HashMap<>(map);
    //             count = s1.length();
    //             left = right + 1;
    //             continue;
    //         }
    //
    //         tmp.put(c, tmp.get(c) - 1);
    //         if (tmp.get(c) >= 0) count--;
    //
    //         while (tmp.get(c) < 0) {
    //             char l = s2.charAt(left++);
    //             tmp.put(l, tmp.get(l) + 1);
    //             if (tmp.get(l) > 0) count++;
    //         }
    //
    //         if (count == 0) return true;
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "afalkhfbaeea"));
        System.out.println(checkInclusion("ab", "afalkhfbhaeea"));
        System.out.println(checkInclusion("a", "ab"));
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }
}
