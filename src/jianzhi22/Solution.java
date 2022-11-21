package jianzhi22;

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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        int a = n - k;
        p = head;
        for (int i = 0; i <  a; i++) {
            p = p.next;
        }
        return p;
    }
}
