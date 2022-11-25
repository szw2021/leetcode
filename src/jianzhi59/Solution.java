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
        return queue2.peekFirst();
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
        //todo Integer
        if (queue1.peek().equals(queue2.peek())) {
            queue2.poll();
        }
        return queue1.poll();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
        }

        int index = 0;
        res[index++] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            int pop = nums[i - k];
            if (pop == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
            res[index++] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(arr, 3);

    }
}