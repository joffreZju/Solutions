package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 */
public class Solution111 {
    private static int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{1, 2, 3, 4, null, null});
        System.out.println(minDepth(root));
    }
}
