package jianzhi07;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length -1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pl]);
        int k = map.get(preorder[pl]);
        node.left = build(preorder, inorder, pl + 1, pl + 1 +  k - il - 1, il, k - 1);
        node.right = build(preorder, inorder, pl + 1 + k - il, pr , k + 1, ir);
        return node;
    }
}
