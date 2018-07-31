package leetcode.round_1.problem501;

import leetcode.util.TreeNode;

/**
 * 538. Convert BST to Greater Tree
 */
public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }

    private static int sum;

    private static void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
    }
}
