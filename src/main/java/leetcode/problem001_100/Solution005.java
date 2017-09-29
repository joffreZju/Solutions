package leetcode.problem001_100;

import java.util.*;

/**
 * Created by joffre on 2017/9/22.
 * 5. Longest Palindromic Substring
 */
public class Solution005 {
    // 暴力超时
    // public static String longestPalindrome(String s) {
    //     if (s.length() < 2) return s;
    //     Map<Character, List<Integer>> locations = new LinkedHashMap<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (locations.containsKey(c)) {
    //             locations.get(c).add(i);
    //         } else {
    //             locations.put(c, new ArrayList<>());
    //             locations.get(c).add(i);
    //         }
    //     }
    //     String res = s.substring(0, 1);
    //     for (List<Integer> list : locations.values()) {
    //         if (list.size() < 2) {
    //             continue;
    //         }
    //         int len = list.size();
    //         for (int i = 0; i < len; i++) {
    //             int begin = list.get(i);
    //             if (list.get(len - 1) - begin + 1 < res.length()) {
    //                 break;
    //             }
    //             for (int j = len - 1; j > i; j--) {
    //                 int end = list.get(j);
    //                 if (end - begin + 1 < res.length()) {
    //                     break;
    //                 }
    //                 String sub = s.substring(begin, end + 1);
    //                 if (isPalindromStr(sub)) {
    //                     if (sub.length() > res.length()) {
    //                         res = sub;
    //                     }
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
    //
    // public static boolean isPalindromStr(String s) {
    //     int i = 0, last = s.length() - 1;
    //     if (last < 1) return true;
    //     while (i < last) {
    //         if (s.charAt(i++) != s.charAt(last--)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, end = 1;
        for (int i = 0, len = s.length(); i < len; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > end - start) {
                start = left + 1;
                end = right;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > end - start) {
                start = left + 1;
                end = right;
            }
        }
        return s.substring(start, end);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bab"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babadada"));
        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
        System.out.println(longestPalindrome("aaaaaaaaaaa"));

    }
}
