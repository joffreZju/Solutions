package leetcode.problem201;

import leetcode.util.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 */
public class Solution222 {
    // 也可以用迭代的方式计算
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHigh = heightOf(root.left), rightHigh = heightOf(root.right);
        if (leftHigh == rightHigh) {
            return (1 << leftHigh) + countNodes(root.right);
        } else {
            return (1 << rightHigh) + countNodes(root.left);
        }
    }

    private static int heightOf(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(countNodes(root));
        System.out.println(heightOf(root));
    }
}
