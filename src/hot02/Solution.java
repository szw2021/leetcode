package hot02;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //reverse
//        ListNode a = l1;
//        ListNode b = l1.next;
//        while (b != null) {
//          ListNode c = b.next;
//          b.next = a;
//          a = b;
//          b = c;
//        }
//        l1.next = null;
//        ListNode head1 = a;
//
//        a = l2;
//        b = l2.next;
//        while (b != null) {
//            ListNode c = b.next;
//            b.next = a;
//            a = b;
//            b = c;
//        }
//        l2.next = null;
//        ListNode head2 = a;
//
//        ListNode dummy = new ListNode(-1);
//        a = dummy;
//        int carry = 0;
//        while (head1 != null && head2 != null) {
//            int num = head1.val + head2.val + carry;
//            a.next = new ListNode(num % 10);
//            carry = num / 10;
//            a = a.next;
//            head1 = head1.next;
//            head2 = head2.next;
//        }
//
//        while (head1 != null) {
//            int num = head1.val + carry;
//            a.next = new ListNode(num % 10);
//            carry = num / 10;
//            a = a.next;
//            head1 = head1.next;
//        }
//
//        while (head2 != null) {
//            int num = head2.val + carry;
//            a.next = new ListNode(num % 10);
//            carry = num / 10;
//            a = a.next;
//            head2= head2.next;
//        }
//        if (carry != 0) {
//            a.next = new ListNode(1);
//        }
//
//        return dummy.next;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carryout = 0;
        while (l1 != null && l2 != null) {
            int res = carryout + l1.val + l2.val;
            p.next = new ListNode(res % 10);
            carryout = res / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while (l1 != null) {
            int res = carryout + l1.val;
            p.next = new ListNode(res % 10);
            carryout = res / 10;
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            int res = carryout + l2.val;
            p.next = new ListNode(res % 10);
            carryout = res / 10;
            l2 = l2.next;
            p = p.next;
        }
        if (carryout != 0) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);
    }
}
