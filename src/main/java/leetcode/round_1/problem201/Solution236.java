package leetcode.round_1.problem201;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class Solution236 {
    // Solution1: recursive
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }

    // Solution2: postOrder find path and  compare path
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp = postOrder(root, p);
        List<TreeNode> pathq = postOrder(root, q);
        for (int i = Math.min(pathp.size(), pathq.size()) - 1; i >= 0; i--) {
            if (pathp.get(i).equals(pathq.get(i))) return pathp.get(i);
        }
        return root;
    }

    private static List<TreeNode> postOrder(TreeNode root, TreeNode target) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                if (cur == target) {
                    return new ArrayList<>(stack);
                }
                cur = cur.left;
            } else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            } else {
                cur = stack.pop();
                pre = cur;
                cur = null;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;

        System.out.println(lowestCommonAncestor(root1, root2, root4).val);
        System.out.println(lowestCommonAncestor(root1, root5, root4).val);
        System.out.println(lowestCommonAncestor(root1, root5, root6).val);
    }
}
