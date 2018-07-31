package leetcode.round_1.problem801;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution831 {
    public static String maskPII(String S) {
        if (S.lastIndexOf('@') != -1) return maskEmail(S);
        else return maskPhone(S);
    }

    private static String maskEmail(String s) {
        String[] parts = s.split("@");
        String name = parts[0].toLowerCase();
        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + parts[1].toLowerCase();
    }

    private static String maskPhone(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') list.add(c);
        }
        String res = "";
        switch (list.size()) {
            case 11:
                res += "+*-";
                break;
            case 12:
                res += "+**-";
                break;
            case 13:
                res += "+***-";
                break;
        }
        res += "***-***-";
        for (int i = list.size() - 4; i < list.size(); i++) {
            res += list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com"));
        System.out.println(maskPII("AB@qq.com"));
        System.out.println(maskPII("1(234)567-890"));
        System.out.println(maskPII("86-(10)12345678"));
    }
}

