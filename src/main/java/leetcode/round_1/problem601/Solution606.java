package leetcode.round_1.problem601;

import leetcode.util.TreeNode;

/**
 * 606. Construct String from Binary Tree
 */
public class Solution606 {
    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        else if (t.left == null && t.right == null) return String.valueOf(t.val);
        else if (t.left != null && t.right != null) {
            return String.valueOf(t.val) + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
        } else if (t.right != null) {
            return String.valueOf(t.val) + "()(" + tree2str(t.right) + ")";
        } else {
            return String.valueOf(t.val) + "(" + tree2str(t.left) + ")";
        }
    }

}
