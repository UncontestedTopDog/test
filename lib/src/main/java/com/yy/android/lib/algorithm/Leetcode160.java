package com.yy.android.lib.algorithm;

class Leetcode160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // boolean changeA = false;
        // boolean changeB = false;
        // while (nodeA != null && nodeB != null) {
        //     if (nodeA == nodeB) {
        //         return nodeA;
        //     }
        //     nodeA = nodeA.next;
        //     if (nodeA == null && !changeA) {
        //         nodeA = headB;
        //         changeA = true;
        //     }
        //     nodeB = nodeB.next;
        //     if (nodeB == null && !changeB) {
        //         nodeB = headA;
        //         changeB = true;
        //     }
        // }
        // return null;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
