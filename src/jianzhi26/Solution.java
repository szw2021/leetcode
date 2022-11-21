package jianzhi26;

class TreeNode {
    public int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
class Solution {
    //todo
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }

        if (isPart(A, B)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isPart(TreeNode left, TreeNode right) {
        if (right == null) {
            return true;
        }
        if (left == null || left.val != right.val) {
            return false;
        }

        return isPart(left.left, right.left) && isPart(left.right, right.right);
    }
}
