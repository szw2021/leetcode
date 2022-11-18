package leet24;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy;;) {
            ListNode q = p;
            for (int i = 0; i < 2; i++) {
                if (q == null) {
                    break;
                }
                q = q.next;
            }
            if (q == null) {
                break;
            }
            ListNode a = p.next;
            ListNode b = a.next;
            for (int i = 0; i < 1; i++) {
                ListNode c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            ListNode d = p.next;
            p.next.next = b;
            p.next = a;
            p = d;
        }
        return dummy.next;
    }
}
