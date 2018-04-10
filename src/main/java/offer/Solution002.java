package offer;

import leetcode.util.TreeNode;

import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution002 {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); ) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
                i += 3;
            } else {
                i++;
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        new PriorityQueue<Integer>((a, b) -> b - a);
        new TreeMap<>();
        new LinkedHashMap<>();
        new HashMap<>();
        new ConcurrentHashMap<>();
    }

}