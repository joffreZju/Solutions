package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class Solution102 {
    public static List<List<Integer>> levelOrderPretty(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSum = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < levelSum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                tmp.add(queue.poll().val);
            }
            res.add(tmp);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.offer(root);
        int curLevel = 1, nextLevel = 0;
        while (!queue.isEmpty()) {
            node = queue.poll();
            tmp.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            if (--curLevel == 0) {
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));

    }
}
