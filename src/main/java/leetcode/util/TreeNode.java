package leetcode.util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // todo 有bug
    public static TreeNode generateTreeFromLevelOrder(Integer[] numbers) {
        int i = 0;
        Queue<TreeNode> curLevel = new LinkedList<>();
        TreeNode root = new TreeNode(numbers[i++]);
        curLevel.offer(root);
        while (!curLevel.isEmpty() && i < numbers.length) {
            TreeNode cur = curLevel.poll();

            if (numbers[i] == null) cur.left = null;
            else cur.left = new TreeNode(numbers[i]);
            i++;

            if (i >= numbers.length) break;

            if (numbers[i] == null) cur.right = null;
            else cur.right = new TreeNode(numbers[i]);
            i++;

            curLevel.offer(cur.left);
            curLevel.offer(cur.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateTreeFromLevelOrder(new Integer[]{1, 2, 3, null, 4, null, 5});
        System.out.println(root.val);
        System.out.println(root.left.val + "-" + root.right.val);
        System.out.println(root.left.left + "-" + root.left.right.val + "***" + root.right.left + "-" + root.right.right.val);
    }
}
