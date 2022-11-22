package jianzhi59;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class MaxQueue {

    Queue<Integer> queue1 = new ArrayDeque<>();
    Deque<Integer> queue2 = new ArrayDeque<>();
    public MaxQueue() {

    }

    public int max_value() {
        if (queue2.size() == 0) {
            return -1;
        }
        return queue2.peek();
    }

    public void push_back(int value) {
        queue1.offer(value);
        if (queue2.isEmpty()) {
            queue2.offer(value);
        } else {
            while (!queue2.isEmpty() && queue2.peekLast() < value) {
                queue2.pollLast();
            }
            queue2.offer(value);
        }
    }

    public int pop_front() {
        if (queue1.size() == 0) {
            return -1;
        }
        if (queue1.peek().equals(queue2.peek())) {
            queue2.poll();
        }
        return queue1.poll();
    }
}
