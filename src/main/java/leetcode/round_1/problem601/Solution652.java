package leetcode.round_1.problem601;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 */
public class Solution652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        serialize(root, map);

        List<TreeNode> res = new ArrayList<>();
        for (List<TreeNode> value : map.values()) {
            if (value.size() > 1) {
                res.add(value.get(0));
            }
        }
        return res;
    }

    private static String serialize(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) return "";
        String serial = "(" + serialize(root.left, map) + root.val + serialize(root.right, map) + ")";
        if (!map.containsKey(serial)) map.put(serial, new ArrayList<>());
        map.get(serial).add(root);
        return serial;
    }
}
