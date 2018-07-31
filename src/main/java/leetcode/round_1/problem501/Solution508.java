package leetcode.round_1.problem501;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 508. Most Frequent Subtree Sum
 */
public class Solution508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        recursive(root, countMap);

        Map<Integer, List<Integer>> freq = new HashMap<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (!freq.containsKey(entry.getValue())) {
                freq.put(entry.getValue(), new ArrayList<>());
            }
            freq.get(entry.getValue()).add(entry.getKey());

            max = Math.max(max, entry.getValue());
        }

        int[] res = new int[freq.get(max).size()];
        int i = 0;
        for (int num : freq.get(max)) res[i++] = num;
        return res;
    }

    private static int recursive(TreeNode root, Map<Integer, Integer> countMap) {
        int sum = root.val;
        if (root.left != null) {
            sum += recursive(root.left, countMap);
        }
        if (root.right != null) {
            sum += recursive(root.right, countMap);
        }
        countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
