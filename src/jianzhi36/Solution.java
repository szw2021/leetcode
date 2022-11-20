package jianzhi36;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    List<Node> in = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
       if (root == null) {
           return null;
       }
       inOrder(root);
       Node pre = in.get(0);
       for (int i = 1; i < in.size(); i++) {
           Node curr = in.get(i);
           pre.right = curr;
           curr.left = pre;
           pre = curr;
       }
       Node head = in.get(0);
       Node tail = in.get(in.size() - 1);
       head.left = tail;
       tail.right = head;
       return head;
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        in.add(node);
        inOrder(node.right);
    }
}
