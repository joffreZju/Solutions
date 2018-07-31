package leetcode.round_1.problem101;

import leetcode.util.ListNode;

/**
 * 148. Sort List
 * 单链表 mergeSort 或者 quickSort
 */
public class Solution148 {
    public static ListNode sortList(ListNode head) {
        // return mergeSort(head);

        quickSort(head, null);
        return head;
    }

    // mergeSort
    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(mergeSort(head), mergeSort(fast));
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    // quickSort
    public static void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode pos = partition(head, tail);
            quickSort(head, pos);
            quickSort(pos.next, tail);
        }
    }

    private static ListNode partition(ListNode head, ListNode tail) {
        ListNode p = head, q = head.next;
        while (q != tail) {
            if (q.val < head.val) {
                p = p.next;
                swap(q, p);
            }
            q = q.next;
        }
        swap(p, head);
        return p;
    }

    private static void swap(ListNode n1, ListNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
