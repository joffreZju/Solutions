package leetcode.problem601;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. Add One Row to Tree
 */
public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1 || root == null) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                if (level == d - 1) {
                    TreeNode n = new TreeNode(v), m = new TreeNode(v);
                    n.left = first.left;
                    first.left = n;
                    m.right = first.right;
                    first.right = m;
                } else {
                    if (first.left != null) queue.offer(first.left);
                    if (first.right != null) queue.offer(first.right);
                }
            }
            if (level == d - 1) break;
            else level++;
        }
        return root;
    }
}
