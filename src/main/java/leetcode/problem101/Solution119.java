package leetcode.problem101;

import java.util.ArrayList;
import java.util.List;

/*
119. Pascal's Triangle II
 */
public class Solution119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        while (cur.size() <= rowIndex) {
            int pre = cur.get(0);
            for (int i = 1; i < cur.size(); i++) {
                int tmp = cur.get(i);
                cur.set(i, pre + cur.get(i));
                pre = tmp;
            }
            cur.add(1);
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(getRow(6));
    }
}
