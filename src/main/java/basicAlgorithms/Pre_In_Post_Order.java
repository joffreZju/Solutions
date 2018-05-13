package basicAlgorithms;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 二叉树的非递归前中后序遍历
 */
public class Pre_In_Post_Order {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root, pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            } else {
                res.add(stack.peek().val);
                pre = stack.pop();
                //cur = null;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                res.add(stack.peek().val);
                cur = stack.pop().right;
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
        return res;
    }
}
