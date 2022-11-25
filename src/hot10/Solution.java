package hot10;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int k = len - n + 1;
        p = dummy;
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
