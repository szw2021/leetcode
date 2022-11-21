package jianzhi34;


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
//todo
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        dfs(root, 0, target, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int sum, int target, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            res.add(new ArrayList<>(list));
        }

        dfs(root.left, sum, target, list);
        dfs(root.right, sum, target, list);

        list.remove(list.size() - 1);
    }
}
