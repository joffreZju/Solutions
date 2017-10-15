package leetcode.problem001_050;

import leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joffre on 2017/9/30.
 * 19. Remove Nth Node From End of List
 */
public class Solution019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        Map<Integer, ListNode> location = new HashMap<>();
        int len = 0;
        while (tmp != null) {
            location.put(++len, tmp);
            tmp = tmp.next;
        }
        if (len == 0) {
            return null;
        }

        ListNode remove = location.get(len - n + 1);
        if (len == n) {
            return remove.next;
        } else if (n == 1) {
            location.get(len - n).next = null;
            return head;
        } else {
            location.get(len - n).next = remove.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode.printListNode(Solution019.removeNthFromEnd(ListNode.parse(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(Solution019.removeNthFromEnd(ListNode.parse(new int[]{}), 0));
        System.out.println(Solution019.removeNthFromEnd(ListNode.parse(new int[]{1}), 1));
        ListNode.printListNode(Solution019.removeNthFromEnd(ListNode.parse(new int[]{1, 2}), 1));
        ListNode.printListNode(Solution019.removeNthFromEnd(ListNode.parse(new int[]{1, 2}), 2));
    }
}
