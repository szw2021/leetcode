package hot21;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] flag;
    public List<List<Integer>> permute(int[] nums) {
        flag = new boolean[nums.length];
        dfs(nums, flag, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, boolean[] flag, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                list.add(nums[i]);
                dfs(nums, flag, list);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
}
