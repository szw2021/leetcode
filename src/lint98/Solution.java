package lint98;

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
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
//        int n = 0;
//        ListNode p = head;
//        while (p != null) {
//            n++;
//            p = p.next;
//        }
//        p = head;
//        for (int i = 0; i < n / 2 - 1; i++) {
//            p = p.next;
//        }
//        ListNode q = p.next;
//        p.next = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail = tail.next = left;
                left = left.next;
            } else {
                tail = tail.next = right;
                right = right.next;
            }
        }
        if (left != null) {
            tail.next = left;
        }
        if ((right != null)) {
            tail.next = right;
        }

        return dummy.next;
    }

}
