package leetcode.problem051_100;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/11/2.
 * 83. Remove Duplicates from Sorted List
 */
public class Solution083 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) pre.next = cur.next;
            else pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 1, 2, 3, 3, 4, 5, 5})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 2})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 1})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{})));
    }
}
