package leetcode.round_1.problem801;

import java.util.HashSet;
import java.util.Set;

/**
 * 804 Unique Morse Code Words
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] tab = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                int index = w.charAt(i) - 'a';
                sb.append(tab[index]);
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
            }
        }
        return set.size();
    }

}
