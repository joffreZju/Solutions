package leetcode.problem401;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 */
public class Solution454 {
    // clear
    public static int fourSumCountClear(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                sumAB.put(a + b, sumAB.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                count += sumAB.getOrDefault(0 - c - d, 0);
            }
        }
        return count;
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        Map<Integer, Integer> sumCD = new HashMap<>();
        helper(A, B, sumAB);
        helper(C, D, sumCD);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sumAB.entrySet()) {
            if (sumCD.containsKey(0 - entry.getKey())) {
                count += (entry.getValue() * sumCD.get(0 - entry.getKey()));
            }
        }
        return count;
    }

    private static void helper(int[] A, int[] B, Map<Integer, Integer> sumAB) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = A[i] + B[j];
                sumAB.put(tmp, sumAB.getOrDefault(tmp, 0) + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fourSumCountClear(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
