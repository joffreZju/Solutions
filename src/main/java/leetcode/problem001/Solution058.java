package leetcode.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/16.
 * 58. Length of Last Word
 */
public class Solution058 {
    public static int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        System.out.println(Arrays.toString(strs));
        if (strs.length == 0)
            return 0;
        else return strs[strs.length - 1].length();
    }

    public static void main(String[] args) {
        lengthOfLastWord("hello world");
        lengthOfLastWord(" hello world ");
        lengthOfLastWord("hello ");
        lengthOfLastWord(" hello");
        lengthOfLastWord("");
        lengthOfLastWord(" ");

    }
}
