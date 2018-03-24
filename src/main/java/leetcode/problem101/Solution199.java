package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
public class Solution199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                queue.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{1, 2, 3, 4});
        System.out.println(rightSideView(root));
    }

}
