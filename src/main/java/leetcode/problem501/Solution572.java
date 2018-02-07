package leetcode.problem501;

import leetcode.util.TreeNode;

/**
 * 572. Subtree of Another Tree
 */
public class Solution572 {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s != null && t != null) {
            return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        } else return false;
    }

    private static boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s != null && t != null) {
            return s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right);
        } else return false;
    }

    public static void main(String[] args) {
        TreeNode s = TreeNode.generateTreeFromLevelOrder(new Integer[]{1, 1}), t = new TreeNode(1);
        System.out.println(isSubtree(s, t));
    }
}
