package leetcode.problem001_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joffre on 2017/9/15.
 * Integer to Roman
 * I    V   X   L   C   D   M
 * 1    5   10  50  100 500 1000
 */
public class Solution012 {
    public String intToRoman(int num) {
        Map<Integer, Character> value = new HashMap<>();
        value.put(1, 'I');
        value.put(5, 'V');
        value.put(10, 'X');
        value.put(50, 'L');
        value.put(100, 'C');
        value.put(500, 'D');
        value.put(1000, 'M');
        List<Integer> list = Arrays.asList(1000, 100, 10, 1);
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            int div = num / cur;
            if (div == 4) {
                res.append(value.get(cur)).append(value.get(cur * 5));
            } else if (div == 9) {
                res.append(value.get(cur)).append(value.get(cur * 10));
            } else if (div < 5) {
                while (div-- > 0) {
                    res.append(value.get(cur));
                }
            } else if (div == 5) {
                res.append(value.get(cur * 5));
            } else if (div > 5) {
                res.append(value.get(cur * 5));
                while (div-- > 5) {
                    res.append(value.get(cur));
                }
            }
            num %= cur;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution012 solution012 = new Solution012();
        System.out.println(solution012.intToRoman(1954));   // MCMLIV
        System.out.println(solution012.intToRoman(1990));   // MCMXC
        System.out.println(solution012.intToRoman(2014));   // MMXIV
        System.out.println(solution012.intToRoman(3999));   //
    }
}
