package leetcode.problem601;

import leetcode.util.TreeNode;

/**
 * 687. Longest Univalue Path
 */
public class Solution687 {
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        res = 0;
        longestPathFromRoot(root);
        return res;
    }

    private static int res;

    private static int longestPathFromRoot(TreeNode root) {
        if (root == null) return 0;
        int left = longestPathFromRoot(root.left), right = longestPathFromRoot(root.right);
        int l = 0, r = 0;
        if (root.left != null && root.left.val == root.val) l += left + 1;
        if (root.right != null && root.right.val == root.val) r += right + 1;
        res = Math.max(res, r + l);
        return Math.max(r, l);
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.generateTreeFromLevelOrder(new Integer[]{1, 4, 5, 4, 4, null, 5});
//        TreeNode root = TreeNode.generateTreeFromLevelOrder(new Integer[]{5, 4, 5, 1, 1, null, 5});
//        TreeNode root = TreeNode.generateTreeFromLevelOrder(new Integer[]{5, 4, 5, 1, 1, 5});
        TreeNode root = TreeNode.generateTreeFromLevelOrder(new Integer[]{1, 1});
        System.out.println(longestUnivaluePath(root));
    }
}
