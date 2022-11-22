package jianzhi54;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    List<TreeNode> inorder = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        inOrder(root);
        for (int i = 0; i < inorder.size(); i++) {
            System.out.println(inorder.get(i).val);
        }
        int num = inorder.size();
        return inorder.get(num - k).val;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inorder.add(node);
        inOrder(node.right);
    }
}
