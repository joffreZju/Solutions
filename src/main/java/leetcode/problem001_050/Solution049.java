package leetcode.problem001_050;

import java.util.*;

/**
 * Created by joffre on 2017/10/13.
 * 49. Group Anagrams
 */
public class Solution049 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // int[] prims = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        int[] prims = new int[26];
        int count = 0;
        for (int i = 2; count < 26; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prims[count++] = i;
            }
        }

        Map<Long, List<String>> map = new HashMap<>();
        for (String cur : strs) {
            long hash = 1;
            for (int j = 0; j < cur.length(); j++) {
                hash *= prims[cur.charAt(j) - 'a'];
            }
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(cur);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
