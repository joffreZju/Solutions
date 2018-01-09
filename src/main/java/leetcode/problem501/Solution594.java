package leetcode.problem501;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 594. Longest Harmonious Subsequence
 */
public class Solution594 {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> treeMap = new HashMap<>();
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0, low = 0, high = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (treeMap.containsKey(entry.getKey() + 1)) {
                if (maxLen < entry.getValue() + treeMap.get(entry.getKey() + 1)) {
                    maxLen = entry.getValue() + treeMap.get(entry.getKey() + 1);
                    low = entry.getKey();
                    high = entry.getKey() + 1;
                }
            }
        }
        if (maxLen == 0) return 0;
        return treeMap.get(low) + treeMap.get(high);
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 1, 1, 1}));
        System.out.println(findLHS(new int[]{1, 2, 1, 2, 1, 2, 1}));
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
