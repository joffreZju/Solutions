package leetcode.round_1.problem401;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 437. Path Sum III
 */
public class Solution437 {
    // Solution1: awesome recursive
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathSumFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == sum) count++;
        count += pathSumFrom(root.left, sum - root.val);
        count += pathSumFrom(root.right, sum - root.val);
        return count;
    }

    // Solution2: prefix sum use HashMap
    private static int res;

    public static int pathSumPreSum(TreeNode root, int sum) {
        res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        helper(root, 0, sum, preSum);
        return res;
    }

    private static void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) return;
        // 这里思路同 560题
        curSum += root.val;
        if (preSum.containsKey(curSum - target)) res += preSum.get(curSum - target);

        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        helper(root.left, curSum, target, preSum);
        helper(root.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println(pathSum(root, 8));

        root = TreeNode.deserializeTree(new Integer[]{0, 1, 1});
        System.out.println(pathSum(root, 1));
    }
}
