package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class Solution114 {
    /**
     * Solution0: Non-recursive
     * https://discuss.leetcode.com/topic/5653/java-solution-recursive-non-recursive
     * 1、对于每一个节点node，找到其左子树最右边的节点为leftRightMost（该节点right为空）
     * 2、将node.right挂在leftRightMost.right
     * 3、将node.left挂在node.right，node.left = null
     * 4、循环1/2/3，下一个处理节点是node.right
     */
    public static void flattenStack(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left, right = cur.right;
            if (left != null) {
                TreeNode leftMostRight = left;
                while (leftMostRight.right != null) {
                    leftMostRight = leftMostRight.right;
                }
                cur.left = null;
                cur.right = left;
                leftMostRight.right = right;
            }
            cur = cur.right;
        }
    }

    //    Solution1: 更好理解的递归解法
    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

    //    Solution2: recursive
    public static void flattenRecursive(TreeNode root) {
        helper(root);
    }

    private static TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left), right = helper(root.right);
        TreeNode cur = root;
        cur.left = null;
        cur.right = left;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        flatten(root);

        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
        System.out.println(root.right.right.right.val);
    }
}
