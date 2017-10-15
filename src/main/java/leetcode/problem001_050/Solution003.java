package leetcode.problem001_050;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joffre on 2017/9/20.
 * 3. Longest Substring Without Repeating Characters
 * 固定left，right向右扫描，同时将位置存储在Map中
 * 如果当前字母在Map中存在 并且 其位置大于left，那么更新left为该位置+1
 * 每一次都将cur字母位置存到Map，并尝试更新max
 */
public class Solution003 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> location = new HashMap<>();
        int left = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (location.containsKey(cur) && location.get(cur) >= left) {
                left = location.get(cur) + 1;
            }
            location.put(cur, i);
            if (i - left > max) {
                max = i - left;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
