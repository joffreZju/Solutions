package leetcode.problem801;

/**
 * 806 Number of Lines To Write String
 */
public class Solution806 {
    public int[] numberOfLines(int[] widths, String S) {
        int w = 100;
        int line = 1, cur = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            if (cur + widths[index] > w) {
                line++;
                cur = widths[index];
            } else {
                cur += widths[index];
            }
        }
        return new int[]{line, cur};
    }
}
