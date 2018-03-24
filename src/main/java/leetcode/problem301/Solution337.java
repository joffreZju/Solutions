package leetcode.problem301;

import leetcode.util.TreeNode;

/**
 * 337. House Robber III
 */
public class Solution337 {
    // Solution1
    // dfs all the nodes of the tree, each node return two number, int[] num,
    // num[0] is the max value while rob this node,
    // num[1] is max value while not rob this value.
    // Current node return value only depend on its children’s value.
    public static int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }

    private static int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }


    // Solution2
    // public static int rob(TreeNode root) {
    //     return helper(root, false);
    // }
    //
    // private static int helper(TreeNode root, boolean forbidden) {
    //     if (root == null) return 0;
    //     if (forbidden) {
    //         return helper(root.left, false) + helper(root.right, false);
    //     } else {
    //         return Math.max(root.val + helper(root.left, true) + helper(root.right, true),
    //                 helper(root.left, false) + helper(root.right, false));
    //     }
    // }


    // Solution3
    // public static int rob(TreeNode root) {
    //     freeMax = new HashMap<>();
    //     forbiddenMax = new HashMap<>();
    //     return helper(root, false);
    // }
    //
    // private static HashMap<TreeNode, Integer> freeMax, forbiddenMax;
    //
    // private static int helper(TreeNode root, boolean forbidden) {
    //     if (root == null) return 0;
    //     int left, right;
    //
    //     if (root.left == null) left = 0;
    //     else if (freeMax.containsKey(root.left)) left = freeMax.get(root.left);
    //     else left = helper(root.left, false);
    //
    //     if (root.right == null) right = 0;
    //     else if (freeMax.containsKey(root.right)) right = freeMax.get(root.right);
    //     else right = helper(root.right, false);
    //
    //     forbiddenMax.put(root, left + right);
    //
    //     if (forbidden) {
    //         return forbiddenMax.get(root);
    //     } else {
    //         if (root.left == null) left = 0;
    //         else if (forbiddenMax.containsKey(root.left)) left = forbiddenMax.get(root.left);
    //         else left = helper(root.left, true);
    //
    //         if (root.right == null) right = 0;
    //         else if (forbiddenMax.containsKey(root.right)) right = forbiddenMax.get(root.right);
    //         else right = helper(root.right, true);
    //
    //         freeMax.put(root, root.val + left + right);
    //
    //         return Math.max(freeMax.get(root), forbiddenMax.get(root));
    //     }
    // }


    // Solution4
    // public static int rob(TreeNode root) {
    //     map = new HashMap<>();
    //     return helper(root);
    // }
    //
    // private static Map<TreeNode, Integer> map;
    //
    // private static int helper(TreeNode root) {
    //     if (root == null) return 0;
    //     if (map.containsKey(root)) return map.get(root);
    //     int left = 0, right = 0;
    //     if (root.left != null) left = helper(root.left.left) + helper(root.left.right);
    //     if (root.right != null) right = helper(root.right.left) + helper(root.right.right);
    //
    //     int max = Math.max(root.val + left + right, helper(root.left) + helper(root.right));
    //     map.put(root, max);
    //     return max;
    // }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.deserializeTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        TreeNode root2 = TreeNode.deserializeTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(1);
        root3.left.left = new TreeNode(2);
        root3.left.left.left = new TreeNode(3);

        System.out.println(rob(root1));
        System.out.println(rob(root2));
        System.out.println(rob(root3));

    }
}
