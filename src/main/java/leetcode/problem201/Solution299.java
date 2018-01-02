package leetcode.problem201;

import java.util.*;

/**
 * 299. Bulls and Cows
 */
public class Solution299 {
    public static String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] hash1 = new int[10], hash2 = new int[10];
        for (int i = 0; i < Math.min(secret.length(), guess.length()); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                hash1[secret.charAt(i) - '0']++;
                hash2[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(hash1[i], hash2[i]);
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1234", "1423"));
        System.out.println(getHint("1122", "2211"));
        System.out.println(getHint("1122", "0001"));
    }
}
