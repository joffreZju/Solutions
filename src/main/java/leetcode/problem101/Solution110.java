package leetcode.problem101;

import leetcode.util.TreeNode;

/**
 * 110. Balanced Binary Tree
 */
public class Solution110 {
    private static boolean flag;

    public static boolean isBalanced(TreeNode root) {
        flag = true;
        calHeight(root);
        return flag && (root == null || root.val <= 1);
    }

    private static int calHeight(TreeNode root) {
        // 将root.val 赋值为 abs(Height(root.left) - Height(root.right))
        // 但是return Height(root)
        // if (root.val > 1) flag = false; 遇到不平衡的子树，记录下来
        if (root == null) return 0;
        else if (root.left == null && root.right == null) {
            root.val = 0;
            return 1;
        } else {
            int left = calHeight(root.left), right = calHeight(root.right);
            root.val = Math.abs(left - right);
            if (root.val > 1) flag = false;
            return 1 + Math.max(left, right);
        }
    }

    // same idea, more simple code
    // static int NOT_BALANCED = -1;
    //
    // public boolean isBalanced(TreeNode root) {
    //     return getDepth(root) != NOT_BALANCED;
    // }
    //
    // int getDepth(TreeNode node) {
    //     if (node == null)
    //         return 0;
    //     int left = getDepth(node.left);
    //     if (left == NOT_BALANCED)
    //         return NOT_BALANCED;
    //     int right = getDepth(node.right);
    //     if (right == NOT_BALANCED)
    //         return NOT_BALANCED;
    //     if (Math.abs(left - right) > 1)
    //         return NOT_BALANCED;
    //     return Math.max(left, right) + 1;
    // }


    // 两次递归
    // public static boolean isBalanced(TreeNode root) {
    //     calHeight(root);
    //     return helper(root);
    // }

    // private static boolean helper(TreeNode root) {
    //     if (root == null) return true;
    //     else if (root.left == null && root.right == null) return true;
    //     else if (root.left == null || root.right == null) {
    //         int childHeight;
    //         if (root.left != null) childHeight = root.left.val;
    //         else childHeight = root.right.val;
    //         return (childHeight <= 1) && helper(root.left) && helper(root.right);
    //     } else {
    //         return (Math.abs(root.left.val - root.right.val) <= 1) && helper(root.left) && helper(root.right);
    //     }
    // }

    // private static int calHeight(TreeNode root) {
    //     if (root == null) return 0;
    //     else if (root.left == null && root.right == null) {
    //         root.val = 1;
    //     } else {
    //         root.val = 1 + Math.max(calHeight(root.left), calHeight(root.right));
    //     }
    //     return root.val;
    // }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5});
        System.out.println(isBalanced(root));
    }
}
