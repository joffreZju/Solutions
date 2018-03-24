package leetcode.problem101;

import leetcode.util.ListNode;

/**
 * 142. Linked List Cycle II
 */
public class Solution142 {
    public ListNode hasCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
