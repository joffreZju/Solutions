package leetcode.problem501;

import leetcode.util.TreeNode;

/**
 * 543. Diameter of Binary Tree
 */
public class Solution543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        height(root);
        return max;
    }

    private static int max;

    private static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left), right = height(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
