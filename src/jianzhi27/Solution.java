package jianzhi27;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

class TreeNode {
    public int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode p = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(p);
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//        TreeNode p = root.left;
//        root.left = root.right;
//        root.right = p;
        return root;

    }
}
