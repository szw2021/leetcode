package jianzhi52;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            if (p != null) {
                p = p.next;
            } else {
                p = headB;
            }

            if (q != null) {
                q = q.next;
            } else {
                q = headA;
            }
        }
        return p;
    }
}
