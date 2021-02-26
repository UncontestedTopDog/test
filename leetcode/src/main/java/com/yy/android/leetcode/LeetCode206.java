package com.yy.android.leetcode;

class LeetCode206 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode first = null;
        ListNode second = head;
        while (second != null ){
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;
    }

    public static ListNode reverseList2(ListNode head) {
        // if (head == null || head.next == null) return head;
        // ListNode temp = head.next;
        // ListNode newHead = reverseList2(head.next);
        // temp.next = head;
        // head.next = null;
        // return newHead;
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode newHead = reverseList2(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

}
