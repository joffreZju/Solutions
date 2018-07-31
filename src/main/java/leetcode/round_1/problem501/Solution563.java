package leetcode.round_1.problem501;

import leetcode.util.TreeNode;

/**
 * 563. Binary Tree Tilt
 */
public class Solution563 {

    public int findTilt(TreeNode root) {
        sum = 0;
        sumOfSubTree(root);
        return sum;
    }

    private static int sum;

    private static int sumOfSubTree(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return root.val;
        int left = sumOfSubTree(root.left), right = sumOfSubTree(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
