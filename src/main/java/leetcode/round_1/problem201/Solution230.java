package leetcode.round_1.problem201;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 */
public class Solution230 {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                k--;
                if (k == 0) return cur.val;
                cur = cur.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{7, 5, 9, 3, 6, 8, 10, null, 4});
        System.out.println(kthSmallest(root, 1));
        System.out.println(kthSmallest(root, 2));
        System.out.println(kthSmallest(root, 3));
        System.out.println(kthSmallest(root, 4));
        System.out.println(kthSmallest(root, 5));
        System.out.println(kthSmallest(root, 6));
        System.out.println(kthSmallest(root, 7));
        System.out.println(kthSmallest(root, 8));
    }
}
