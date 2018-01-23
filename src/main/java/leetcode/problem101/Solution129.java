package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class Solution129 {
    // Solution1: recursive
    private static int res;

    public static int sumNumbers(TreeNode root) {
        res = 0;
        helper(root, 0);
        return res;
    }

    private static void helper(TreeNode root, int num) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += num;
        } else {
            helper(root.left, num);
            helper(root.right, num);
        }
    }

    // Solution2: postOrder
    public static int sumNumbersPostOrder(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        int res = 0, num = 0;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                num = num * 10 + cur.val;
                stack.push(cur);
                cur = cur.left;
            } else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            } else {
                cur = stack.pop();
                if (cur.left == null && cur.right == null) res += num;
                num /= 10;
                pre = cur;
                cur = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTreeFromLevelOrder(new Integer[]{1, 2, 3});
        System.out.println(sumNumbers(root));
    }
}
