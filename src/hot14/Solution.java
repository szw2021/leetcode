package hot14;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = new ListNode(node.val);
            node = node.next;
            if (node != null) {
                pq.add(node);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
