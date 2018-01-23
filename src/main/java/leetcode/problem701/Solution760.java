package leetcode.problem701;

import java.util.*;

/**
 * 760. Find Anagram Mappings
 */
public class Solution760 {
    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) map.put(B[i], new ArrayList<>());
            map.get(B[i]).add(i);
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).get(0);
            map.get(A[i]).remove(0);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
    }
}
