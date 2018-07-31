package leetcode.util;

import leetcode.round_1.problem201.Codec;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // 1,2,3,n,4,5,n,6,n,n,7
    public static TreeNode deserializeTree(String data) {
        return Codec.deserialize(data);
    }

    public static TreeNode deserializeTree(Integer[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0) sb.append(',');
            if (numbers[i] != null) sb.append(numbers[i]);
            else sb.append('n');
        }
        return Codec.deserialize(sb.toString());
    }

    public static void main(String[] args) {
        TreeNode root = deserializeTree(new Integer[]{1, 2, 3, null, 4, 5, null, 6, null, null, 7});
        System.out.println(Codec.serialize(root));
    }
}
