package leetcode.round_2.problem201;

import leetcode.util.ListNode;

/**
 * 206. Reverse Linked List
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, next = head.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;

            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}
