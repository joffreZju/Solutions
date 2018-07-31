package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
