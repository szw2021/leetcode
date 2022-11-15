package lint97;

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
     * @param root: The root of binary tree.
     * @return: An integer
     */
//    public int maxDepth(TreeNode root) {
//        // write your code here
//        if (root == null) {
//            return 0;
//        }
//
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        if (left > right) {
//            return left + 1;
//        }
//        return right + 1;
//    }
    int depth = 0;

    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode node, int currentDepth) {
        if (node == null) {
            return;
        }

        if (depth < currentDepth) {
            depth = currentDepth;
        }

        dfs(node.left, currentDepth + 1);
        dfs(node.right, currentDepth + 1);
    }
}
