package leetcode.problem201;

import leetcode.util.ListNode;

/**
 * 206. Reverse Linked List
 */
public class Solution206 {
    /* 递归
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return head;

        ListNode rHead = reverseList(head.next), cur = rHead;
        while(cur.next != null) cur = cur.next;
        cur.next = head;
        head.next = null;
        return rHead;
    }
    */

    // loop1
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reverse = null, tmp;
        while (head != null) {
            tmp = head.next;
            head.next = reverse;
            reverse = head;
            head = tmp;
        }
        return reverse;
    }

    /* loop2
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = head, n = head.next, nn =  head.next.next;
        head.next = null;

        while(nn != null){
            n.next = cur;
            cur = n;
            n = nn;
            nn = nn.next;
        }
        n.next = cur;
        return n;
    }
    */
}
