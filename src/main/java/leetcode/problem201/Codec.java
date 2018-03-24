package leetcode.problem201;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 297. Serialize and Deserialize Binary Tree
 */

public class Codec {
    // 前序遍历递归，遍历时将所有节点（包括叶节点）的null指针域也加上遍历；
    // 所以在递归构建树时可以通过null完整的构建出左子树，紧接着后面的序列就是属于右子树的；
    // 常规的preOrder是没办法分辨哪部分属于左子树，哪部分属于右子树
    // public static String serialize(TreeNode root) {
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     serializeHelper(root, result);
    //     return result.toString();
    // }
    //
    // private static void serializeHelper(TreeNode root, ArrayList<Integer> result) {
    //     if (root == null) {
    //         result.add(null);
    //         return;
    //     }
    //     result.add(root.val);
    //     serializeHelper(root.left, result);
    //     serializeHelper(root.right, result);
    // }
    //
    // public static TreeNode deserialize(String data) {
    //     String[] strArray = data.substring(1, data.length() - 1).split(", ");
    //     Deque<String> strList = new LinkedList<String>(Arrays.asList(strArray));
    //     return deserializeHelper(strList);
    // }
    //
    // private static TreeNode deserializeHelper(Deque<String> strList) {
    //     if (strList.size() == 0) return null;
    //     String str = strList.pop();
    //     if (str.equals("null")) return null;
    //     TreeNode currentRoot = new TreeNode(Integer.parseInt(str));
    //     currentRoot.left = deserializeHelper(strList);
    //     currentRoot.right = deserializeHelper(strList);
    //     return currentRoot;
    // }


    // Encodes a tree to a single string.
    // 层序遍历：每个非空节点的左右孩子都入队，出队时检测下是否为null，最后清除末尾连续的null
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (sb.length() != 0) sb.append(",");
            if (root != null) {
                sb.append(root.val);
                queue.offer(root.left);
                queue.offer(root.right);
            } else sb.append('n');
        }
        while (sb.charAt(sb.length() - 1) == 'n') {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    // 按照层序构建：一次遍历nodes数组，queue中保存上一层不为null的节点；
    // 将i和i+1位置的值分别给队首的left和right；
    // 如果left或right不是null，那么同时将其入队。
    public static TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode tmp = queue.poll();
            if (nodes[i].equals("n")) {
                tmp.left = null;
            } else {
                tmp.left = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(tmp.left);
            }

            if (i + 1 >= nodes.length) break;

            if (nodes[i + 1].equals("n")) {
                tmp.right = null;
            } else {
                tmp.right = new TreeNode(Integer.valueOf(nodes[i + 1]));
                queue.offer(tmp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        String data = serialize(root);
        System.out.println(data);
        System.out.println(serialize(deserialize(data)).equals(data));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
