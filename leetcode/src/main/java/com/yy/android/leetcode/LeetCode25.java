package com.yy.android.leetcode;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
            if (count == k - 1)
                break;
        }
        if (temp == null) {
            return head;
        }
        int num = k;
        temp = temp.next;
        ListNode headtemp = head;
        ListNode pre = null;
        while (num != 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            num--;
        }
        headtemp.next = reverseKGroup(temp,k);
        return pre;
    }
}
