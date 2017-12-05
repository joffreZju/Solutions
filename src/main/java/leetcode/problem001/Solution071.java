package leetcode.problem001;

/**
 * Created by joffre on 2017/10/19.
 * 71. Simplify Path
 */
public class Solution071 {
    public static String simplifyPath(String path) {
        StringBuilder tmp = new StringBuilder(), res = new StringBuilder();
        for (int i = 0; i < path.length() || tmp.length() != 0; i++) {
            if (i < path.length() && path.charAt(i) != '/') {
                tmp.append(path.charAt(i));
                continue;
            }
            if (tmp.length() != 0) {
                if (tmp.toString().equals("..")) {
                    int index = res.lastIndexOf("/");
                    if (index != -1) res.delete(index, res.length());
                } else if (!tmp.toString().equals(".")) {
                    res.append('/').append(tmp);
                }
                tmp.delete(0, tmp.length());
            }
        }
        if (res.length() == 0) {
            return "/";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/aa/./../bbb/./cc/"));
        System.out.println(simplifyPath("..///aa/./../bbb/./cc///"));
        System.out.println(simplifyPath("//.././/"));
        System.out.println(simplifyPath("/aaa"));
    }
}
