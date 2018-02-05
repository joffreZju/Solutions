package leetcode.problem201;

import leetcode.util.TreeNode;

/**
 * 226. Invert Binary Tree
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        else {
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
        }
        return root;
    }
}
