package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 112. Path Sum
 */
public class Solution112 {

    // recursive
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null) return sum == root.val;
        else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // postorder
    public static boolean hasPathSumPostOrder(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        int curSum = 0;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                curSum += cur.val;
                stack.push(cur);
                cur = cur.left;
            } else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            } else {
                cur = stack.pop();

                if (cur.left == null && cur.right == null && sum == curSum) return true;
                curSum -= cur.val;

                pre = cur;
                cur = null;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{5, 4, 8, 11, null, 13, 4});
        System.out.println(hasPathSum(root, 9));
        System.out.println(hasPathSum(root, 20));

        root = TreeNode.deserializeTree(new Integer[]{-2, null, -3});
        System.out.println(hasPathSum(root, -5));
        System.out.println(hasPathSum(root, -3));
    }
}
