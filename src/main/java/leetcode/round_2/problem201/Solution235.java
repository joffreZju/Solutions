package leetcode.round_2.problem201;

import leetcode.util.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        if (root.val > max) return lowestCommonAncestor(root.left, p, q);
        if (root.val < min) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
