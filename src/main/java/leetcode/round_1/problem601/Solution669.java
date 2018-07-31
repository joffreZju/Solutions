package leetcode.round_1.problem601;

import leetcode.util.TreeNode;

/**
 * 669. Trim a Binary Search Tree
 */
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        else if (root.val < L) return trimBST(root.right, L, R);
        else if (root.val > R) return trimBST(root.left, L, R);
        else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}
