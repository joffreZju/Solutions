package leetcode.problem001;

/**
 * 98. Validate Binary Search Tree
 */

import leetcode.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution098 {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左边最大的，右边最小的
        TreeNode leftMax = root.left, rightMin = root.right;
        while (leftMax != null) {
            if (leftMax.val >= root.val) return false;
            leftMax = leftMax.right;
        }
        while (rightMin != null) {
            if (rightMin.val <= root.val) return false;
            rightMin = rightMin.left;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(isValidBST(root));
    }
}
