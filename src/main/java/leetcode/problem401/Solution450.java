package leetcode.problem401;

import leetcode.util.TreeNode;

/**
 * 450. Delete Node in a BST
 */
public class Solution450 {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode leftMax = root.left;
            while (leftMax.right != null) leftMax = leftMax.right;
            root.val = leftMax.val;
            root.left = deleteNode(root.left, leftMax.val);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTreeFromLevelOrder(new Integer[]{5, 3, 6, 2, 4, null, 7});
        System.out.println(deleteNode(root, 5).val);
    }
}
