package lint453;


import java.util.ArrayList;
import java.util.List;
import java.util.prefs.NodeChangeEvent;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        preOrder(root);
        TreeNode prev;
        TreeNode curr;
        for (int i = 1; i < list.size(); i++) {
            prev = list.get(i - 1);
            curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}
