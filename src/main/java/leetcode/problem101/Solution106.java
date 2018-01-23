package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class Solution106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> in = new ArrayList<>(), post = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            in.add(inorder[i]);
            post.add(postorder[i]);
        }
        return helper(in, post);
    }

    private static TreeNode helper(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.size() == 0) return null;
        TreeNode root = new TreeNode(postorder.get(postorder.size() - 1));
        int index = inorder.lastIndexOf(postorder.get(postorder.size() - 1));

        root.left = helper(inorder.subList(0, index), postorder.subList(0, index));
        root.right = helper(inorder.subList(index + 1, inorder.size()), postorder.subList(index, postorder.size() - 1));
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{}, new int[]{});
        buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1});
    }

}
