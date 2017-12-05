package leetcode.problem001;


/**
 * Created by joffre on 2017/9/18.
 * 38. Count and Say
 */
public class Solution038 {
    public static String countAndSay(int n) {
        String[] base = new String[]{"-", "1", "11", "21", "1211", "111221"};
        if (n <= 5) {
            return base[n];
        }
        String pre = base[5];
        for (int i = 6; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            char c = pre.charAt(0);
            int counter = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) == c) {
                    counter++;
                } else {
                    cur.append(counter).append(c);
                    c = pre.charAt(j);
                    counter = 1;
                }
            }
            cur.append(counter).append(c);
            pre = cur.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        for (int i = 6; i < 15; i++) {
            System.out.println(countAndSay(i));
        }
    }
}
