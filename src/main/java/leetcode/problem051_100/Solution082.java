package leetcode.problem051_100;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/11/1.
 * 82. Remove Duplicates from Sorted List II
 */
public class Solution082 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0); //构建一个前置节点当做pre指针的初始值，并作为返回值
        newHead.next = head;
        ListNode pre = newHead, cursor = head;

        int val = head.val, count = 0;
        while (cursor != null) {
            if (cursor.val == val) {
                count++;
                if (cursor.next == null && count > 1) pre.next = null; //去掉结尾的重复元素
            } else {
                if (count != 1) pre.next = cursor; //指针跳跃，删除当前元素前面的重复元素
                else pre = pre.next; //指针后移，将前一个不重复元素接入列表
                val = cursor.val;
                count = 1;
            }
            cursor = cursor.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 1, 2, 3, 3, 4, 5, 5})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 2, 2, 3})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 2, 3})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1, 2})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{1})));
        ListNode.printListNode(deleteDuplicates(ListNode.parse(new int[]{})));
    }
}
