package leetcode.problem051_100;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/10/16.
 * 61. Rotate List
 */
public class Solution061 {
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode tmp = head, end = head, res = head;
        int sum = 0;
        while (tmp != null) {
            sum++;
            if (tmp.next == null) {
                end = tmp;
            }
            tmp = tmp.next;
        }
        if (sum == 0) return res;

        int count = 0;
        tmp = head;
        k %= sum;
        while (tmp != null) {
            count++;
            if (count == sum - k && tmp.next != null) {
                res = tmp.next;
                tmp.next = end.next;
                end.next = head;
                break;
            }
            tmp = tmp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode.printListNode(rotateRight(ListNode.parse(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
