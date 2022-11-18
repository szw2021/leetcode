package lint36;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null || m > n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode leftPrev = p;
        ListNode left = p.next;

        p = dummy;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        ListNode right = p;
        ListNode rightAfter = p.next;

        ListNode a = left;
        ListNode b = a.next;
        while (b != rightAfter) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        leftPrev.next = a;
        left.next = b;
        return dummy.next;
    }
}
