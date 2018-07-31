package leetcode.round_1.problem101;

import leetcode.util.ListNode;

/**
 * 141. Linked List Cycle
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
