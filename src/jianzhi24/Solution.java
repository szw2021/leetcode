package jianzhi24;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = a.next;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        head.next = null;
        return a;
    }
}
