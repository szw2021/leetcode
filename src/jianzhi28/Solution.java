package jianzhi28;


class TreeNode {
    public int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
