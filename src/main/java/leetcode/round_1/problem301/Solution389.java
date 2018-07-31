package leetcode.round_1.problem301;

/**
 * 389. Find the Difference
 */
public class Solution389 {
    public static char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']++;
        }
        count[t.charAt(t.length() - 1) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) return (char) ('a' + i);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abc", "bcda"));
    }
}
