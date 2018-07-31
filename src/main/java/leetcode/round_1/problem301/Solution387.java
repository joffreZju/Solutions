package leetcode.round_1.problem301;

/**
 * 387. First Unique Character in a String
 */
public class Solution387 {
    public static int firstUniqChar(String s) {
        int[] count = new int[26], location = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            count[c - 'a']++;
            location[c - 'a'] = i;
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                minIndex = Math.min(minIndex, location[i]);
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
