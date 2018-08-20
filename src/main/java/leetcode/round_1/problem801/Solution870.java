package leetcode.round_1.problem801;

import java.util.*;

/**
 * 870. Advantage Shuffle
 */
public class Solution870 {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);

        for (int i = 0; i < A.length; i++) {
            Integer k = map.higherKey(B[i]);
            if (k == null) k = map.firstKey();

            A[i] = k;
            if (map.get(k) == 1) map.remove(k);
            else map.put(k, map.get(k) - 1);
        }

        return A;
    }
}