package leetcode.round_1.problem001;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/11/3.
 * 86. Partition List
 */
public class Solution086 {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode left = newHead, right, preRight, tmp;

        while (left.next != null && left.next.val < x) left = left.next;

        preRight = left;
        right = left.next;
        while (right != null) {
            if (right.val < x) {
                //把一个小于x的节点从右边删除，移动到左边的最后一个节点
                tmp = left.next;
                left.next = right;

                right = right.next;
                preRight.next = right;

                left = left.next;
                left.next = tmp;
            } else {
                preRight = right;
                right = right.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(partition(ListNode.parse(new int[]{1, 4, 3, 2, 5, 2}), 3));
        ListNode.printListNode(partition(ListNode.parse(new int[]{}), 3));
        ListNode.printListNode(partition(ListNode.parse(new int[]{4}), 3));
        ListNode.printListNode(partition(ListNode.parse(new int[]{1}), 3));
    }
}
