package leetcode.problem001;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 */
public class Solution076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, needToMatch = t.length();
        int resLeft = 0, resRight = Integer.MAX_VALUE;

        while (right <= s.length() && left < s.length()) {
            if (needToMatch > 0) {
                // right 已经扫描完，还要等待 left 继续向右扫描寻找更优解
                if (right >= s.length()) break;

                char c = s.charAt(right++);
                if (map.containsKey(c)) {
                    // 每次都将 map 对应位置 -1
                    map.put(c, map.get(c) - 1);
                    // map.get(c) >= 0，说明扫描得到的 c 正好抵消了 t 中的一个字符，所以waitMatchingCount--
                    if (map.get(c) >= 0) needToMatch--;
                }
            } else {
                // needToMatch == 0，更新最优解
                if (right - left < resRight - resLeft) {
                    resRight = right;
                    resLeft = left;
                }

                char c = s.charAt(left++);
                if (map.containsKey(c)) {
                    // 每次都将 map 对应位置 +1, 相当于将 map 还原
                    map.put(c, map.get(c) + 1);
                    // 如果 map.get(c) <= 0, 说明这一次还原是补齐了这一段中 s 比 t 多余出的 c 字符
                    // 因为 s[left, right] 如果包含了 t 的全部字符，但是对于某个字符 c, s 中的个数可能多于 t 中的个数
                    // map.get(c) > 0, 说明这一次还原相当于补全了 t 中的一个字符，所以 needToMatch++
                    if (map.get(c) > 0) needToMatch++;
                }
            }
        }
        return resRight == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight);
    }
}
