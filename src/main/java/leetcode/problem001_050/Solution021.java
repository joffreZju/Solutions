package leetcode.problem001_050;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/9/18.
 * 21. Merge Two Sorted Lists
 */

public class Solution021 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur1, cur2, head;
        if (l1.val < l2.val) {
            cur1 = l1;
            cur2 = l2;
            head = l1;
        } else {
            cur1 = l2;
            cur2 = l1;
            head = l2;
        }
        while (cur2 != null) {
            while (cur1.next != null && cur2.val > cur1.next.val) {
                cur1 = cur1.next;
            }
            ListNode tmp1 = cur1.next, tmp2 = cur2.next;
            cur1.next = cur2;
            cur1.next.next = tmp1;
            cur2 = tmp2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(4);

        ListNode merge = Solution021.mergeTwoLists(l1, l2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
