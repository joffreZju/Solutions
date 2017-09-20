package leetcode.problem001_100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joffre on 2017/9/15.
 * Roman to Integer
 * I    V   X   L   C   D   M
 * 1    5   10  50  100 500 1000
 */
public class Solution013 {
    public int romanToInt(String s) {
        Map<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int res = 0, tmpSum = 0;
        int preValue = 9999, curValue;
        for (int i = 0, len = s.length(); i < len; i++) {
            curValue = value.get(s.charAt(i));
            if (curValue < preValue) {
                res += tmpSum;
                tmpSum = curValue;
            } else if (curValue == preValue) {
                tmpSum += curValue;
            } else {
                tmpSum = curValue - tmpSum;
            }
            preValue = curValue;
        }
        return res + tmpSum;
    }

    public static void main(String[] args) {
        Solution013 solution013 = new Solution013();
        System.out.println(solution013.romanToInt("MCMLIV"));   //1954
        System.out.println(solution013.romanToInt("MCMXC"));    //1990
        System.out.println(solution013.romanToInt("MMXIV"));    //2014
    }
}
