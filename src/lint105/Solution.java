package lint105;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
}

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//        RandomListNode p = head;
//        while (p != null) {
//            map.put(p, new RandomListNode(p.label));
//            p = p.next;
//        }
//        p = head;
//        while (p != null) {
//            RandomListNode newList = map.get(p);
//            newList.next = map.get(p.next);
//            newList.random = map.get(p.random);
//            p = p.next;
//        }
//        return map.get(head);
        RandomListNode p = head;
        while (p != null) {
            RandomListNode a = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = a;
            p = a;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        RandomListNode newHead = head.next;
        RandomListNode q = newHead;
        while (p != null) {
            p.next = p.next.next;
            if (q.next != null) {
                q.next = q.next.next;
            }
            p = p.next;
            q = q.next;
        }
        return newHead;
    }

}
