package jianzhi06;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        ListNode a = head;
        ListNode b = a.next;
        int n = 1;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
            n++;
        }
        head.next = null;
        int[] res = new int[n];
        int index = 0;
        while (a != null) {
            res[index++] = a.val;
            a = a.next;
        }
        return res;
    }
}
