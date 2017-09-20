package leetcode.util;

/**
 * Created by joffre on 2017/9/20.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode parse(int[] nums) {
        ListNode root = new ListNode(nums[0]);
        ListNode currentNode = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            currentNode.next = node;
            currentNode = node;
        }
        return root;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print("->");
        }
    }
}
