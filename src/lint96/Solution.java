package lint96;


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
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode dummy1 = new ListNode(-1);
        ListNode tail1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode tail2 = dummy2;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                tail1 = tail1.next = p;
            } else {
                tail2 = tail2.next = p;
            }
            p = p.next;
        }
        tail2.next = null;
        tail1.next = dummy2.next;
        return dummy1.next;
    }
}
