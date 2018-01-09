package leetcode.problem401;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 */
public class Solution428 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Set<String> anagramSet = new HashSet<>();
        anagramSet.add(p);
        for (int i = 0; i + p.length() <= s.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (anagramSet.contains(sub)) {
                res.add(i);
                continue;
            }

            int[] countMap = new int[26];
            for (int j = 0; j < p.length(); j++) {
                countMap[p.charAt(j) - 'a']++;
                countMap[sub.charAt(j) - 'a']--;
            }

            boolean isAnagram = true;
            for (int j = 0; j < 26; j++) {
                if (countMap[j] != 0) isAnagram = false;
            }
            if (isAnagram) {
                anagramSet.add(sub);
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

}
