package jianzhi25;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail = tail.next = l1;
                l1 = l1.next;
            } else {
                tail = tail.next = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            tail = tail.next = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail = tail.next = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}