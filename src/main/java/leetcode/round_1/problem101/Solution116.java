package leetcode.round_1.problem101;

import leetcode.util.TreeLinkNode;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class Solution116 {
    // Solution1
    public static void connect(TreeLinkNode root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    // Solution2
    // public static void connect(TreeLinkNode root) {
    //     if (root == null) return;
    //     TreeLinkNode left = root.left, right = root.right;
    //     while (left != null && right != null) {
    //         left.next = right;
    //         left = left.right;
    //         right = right.left;
    //     }
    //     connect(root.left);
    //     connect(root.right);
    // }
}
