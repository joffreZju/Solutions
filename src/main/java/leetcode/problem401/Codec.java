package leetcode.problem401;

import leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 449. Serialize and Deserialize BST
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private void preOrderSerial(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() > 0) sb.append(',');
        sb.append(root.val);
        preOrderSerial(root.left, sb);
        preOrderSerial(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        preOrderSerial(root, sb);
        return sb.toString();
    }

    private TreeNode preOrderDeserial(List<String> candidate) {
        if (candidate.size() <= 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(candidate.get(0)));
        for (int i = 1; i < candidate.size(); i++) {
            if (Integer.parseInt(candidate.get(i)) > root.val) {
                root.left = preOrderDeserial(candidate.subList(1, i));
                root.right = preOrderDeserial(candidate.subList(i, candidate.size()));
                return root;
            }
        }
        root.left = preOrderDeserial(candidate.subList(1, candidate.size()));
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        List<String> candidate = Arrays.asList(data.split(","));
        return preOrderDeserial(candidate);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));

        TreeNode root_new = codec.deserialize(codec.serialize(root));
        System.out.println(root_new.val);
        System.out.println(root_new.left.val);
        System.out.println(root_new.right.val);
        System.out.println(root_new.left.left.val);
        System.out.println(root_new.left.right.val);
        System.out.println(root_new.right.right.val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
