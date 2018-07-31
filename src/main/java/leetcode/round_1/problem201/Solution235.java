package leetcode.round_1.problem201;

import leetcode.util.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class Solution235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val == root.val) {
                return p;
            } else if (q.val == root.val) {
                return q;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(lowestCommonAncestor(node2, node1, node3).val);

    }
}
