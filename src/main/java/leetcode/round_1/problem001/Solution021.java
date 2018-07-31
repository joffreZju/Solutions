package leetcode.round_1.problem001;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/9/18.
 * 21. Merge Two Sorted Lists
 */

public class Solution021 {
    // Solution1
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else if (l2 != null) cur.next = l2;
        return head.next;
    }

    // Solution3 递归
    // public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) return l2;
    //     else if (l2 == null) return l1;
    //     else if (l1.val <= l2.val) {
    //         l1.next = mergeTwoLists(l1.next, l2);
    //         return l1;
    //     } else if (l1.val > l2.val) {
    //         l2.next = mergeTwoLists(l1, l2.next);
    //         return l2;
    //     }
    //     return null;
    // }

    // Solution2
    // public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) return l2;
    //     else if (l2 == null) return l1;
    //     else if (l1.val > l2.val) return mergeTwoLists(l2, l1);
    //     ListNode aa = l1, bb = l2;
    //     while (bb != null) {
    //         if (aa.next == null) {
    //             aa.next = bb;
    //             break;
    //         } else if (bb.val <= aa.next.val) {
    //             ListNode tmp = aa.next;
    //             aa.next = bb;
    //             bb = bb.next;
    //             aa.next.next = tmp;
    //         }
    //         aa = aa.next;
    //     }
    //     return l1;
    // }

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
