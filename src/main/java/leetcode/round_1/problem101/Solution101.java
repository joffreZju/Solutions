package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 101. Symmetric Tree
 */
public class Solution101 {
    // leftStack存放所有leftNode，rightStack存放所有的rightNode，注意push时入栈顺序
    public static boolean isSymmetricStack(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root.left);
        right.push(root.right);
        while (!left.empty() && !right.empty()) {
            TreeNode ltop = left.pop(), rtop = right.pop();
            if (ltop == null && rtop == null) continue;
            else if (ltop == null || rtop == null || ltop.val != rtop.val) return false;

            left.push(ltop.left);
            left.push(rtop.left);

            right.push(rtop.right);
            right.push(ltop.right);
        }
        return true;
    }

    // 递归
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricSame(root.left, root.right);
    }

    private static boolean isSymmetricSame(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        else if (l == null || r == null) return false;
        else if (l.val != r.val) return false;
        return isSymmetricSame(l.left, r.right) && isSymmetricSame(l.right, r.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
