package jianzhi09;

import java.util.Stack;

class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        int res = -1;
        if (stack1.size() == 1) {
            return stack1.pop();
        }
        while (stack1.size() > 0) {
            stack2.add(stack1.pop());
            if (stack1.size() == 1) {
                res = stack1.pop();
            }
        }
        while (stack2.size() > 0) {
            stack1.add(stack2.pop());
        }
        return res;
    }
}