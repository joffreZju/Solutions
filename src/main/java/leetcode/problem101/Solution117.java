package leetcode.problem101;

import leetcode.util.TreeLinkNode;


/**
 * 117. Populating Next Right Pointers in Each Node II
 */
public class Solution117 {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            // 用一个假的head串联next指针，不需要专门找到root的下一层的head。
            TreeLinkNode nextLevelFakeHead = new TreeLinkNode(-1), nextLevelCur = nextLevelFakeHead;

            // 处理root的下一层
            while (root != null) {
                if (root.left != null) {
                    nextLevelCur.next = root.left;
                    nextLevelCur = nextLevelCur.next;
                }
                if (root.right != null) {
                    nextLevelCur.next = root.right;
                    nextLevelCur = nextLevelCur.next;
                }
                root = root.next;
            }
            // root向下一层
            root = nextLevelFakeHead.next;
        }
    }

    public static void connect_(TreeLinkNode root) {
        while (root != null) {
            // 先找到下一层的head
            TreeLinkNode nextLevelHead = null;
            while (root != null && nextLevelHead == null) {
                if (root.left != null) {
                    nextLevelHead = root.left;
                } else if (root.right != null) {
                    nextLevelHead = root.right;
                } else {
                    root = root.next;
                }
            }
            // 通过遍历root.next,将下一层从head开始串联起来
            TreeLinkNode nextLevelCur = nextLevelHead;
            while (root != null) {
                // 第一次循环nextLevelCur = nextLevelHead 都是root的子节点，需要过滤掉
                if (root.left != null && root.left != nextLevelCur) {
                    nextLevelCur.next = root.left;
                    nextLevelCur = nextLevelCur.next;
                }
                if (root.right != null && root.right != nextLevelCur) {
                    nextLevelCur.next = root.right;
                    nextLevelCur = nextLevelCur.next;
                }
                root = root.next;
            }
            root = nextLevelHead;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        connect_(root);
    }

}
