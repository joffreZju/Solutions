package leetcode.round_1.problem301;

/**
 * 394. Decode String
 */
public class Solution394 {
    public String decodeString(String s) {
        // 递归终止
        if (!s.contains("[")) return s;

        // 去掉开头的字母，作为结果开头部分
        int i1 = 0;
        while (!Character.isDigit(s.charAt(i1))) i1++;
        StringBuilder sb = new StringBuilder(s.substring(0, i1));

        // 找到重复次数 K
        int i2 = i1;
        while (Character.isDigit(s.charAt(i2))) i2++;
        int k = Integer.parseInt(s.substring(i1, i2));

        // 找到与第一个 [ 匹配的 ] 的位置
        int i3 = i2, left = 1;
        while (left > 0) {
            i3++;
            if (s.charAt(i3) == '[') left++;
            else if (s.charAt(i3) == ']') left--;
        }

        // 递归处理第一对 [] 中间的部门
        String part = decodeString(s.substring(i2 + 1, i3));
        for (int i = 0; i < k; i++) {
            sb.append(part);
        }

        // 处理第一对 [] 后面的部分
        sb.append(decodeString(s.substring(i3 + 1, s.length())));
        return sb.toString();
    }
}
