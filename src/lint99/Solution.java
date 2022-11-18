package lint99;


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
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        int mid = (n + 1) / 2;
        p = head;
        for (int i = 0; i < mid - 1; i++) {
            p = p.next;
        }
        ListNode a = p.next;
        ListNode b = a.next;
        p.next = null;
        a.next = null;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        ListNode l1 = head;
        ListNode l2 = a;
        while (l2 != null) {
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
    }
}
