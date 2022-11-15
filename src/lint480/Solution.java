package lint480;

import java.util.ArrayList;
import java.util.List;

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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     *          we will sort your return value in output
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(root.val + "");
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for (String str : left) {
            res.add(root.val + "->" + str);
        }

        for (String str : right) {
            res.add(root.val + "->" + str);
        }

        return res;
    }
}
