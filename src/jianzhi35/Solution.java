package jianzhi35;

class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node p = head;
        Node q;
        while (p != null) {
            Node t = p.next;
            q = new Node(p.val);
            q.next = t;
            p.next = q;
            p = t;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next;
        }

        p = head;
        q = head.next;
        Node newList = q;
        while (p != null) {
            p.next = p.next.next;
            p = p.next;
            if (q.next != null) {
                q.next = q.next.next;
                q = q.next;
            }
        }
        return newList;
    }
}
