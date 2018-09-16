package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class Solution103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (res.size() % 2 == 0) tmp.add(node.val);
                else tmp.add(0, node.val);
            }
            res.add(tmp);
        }
        return res;
    }

    // public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) return res;
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //
    //     int level = 1;
    //     while (!stack.empty()) {
    //         List<TreeNode> nodes = new ArrayList<>();
    //         while (!stack.empty()) nodes.add(stack.pop());
    //
    //         List<Integer> tmp = new ArrayList<>();
    //         for (TreeNode node : nodes) {
    //             // 两种情况left 和 right 入栈顺序不一样
    //             if (level % 2 != 0) {
    //                 if (node.left != null) stack.push(node.left);
    //                 if (node.right != null) stack.push(node.right);
    //             } else {
    //                 if (node.right != null) stack.push(node.right);
    //                 if (node.left != null) stack.push(node.left);
    //             }
    //             tmp.add(node.val);
    //         }
    //         res.add(tmp);
    //         level++;
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(zigzagLevelOrder(root));
    }
}
