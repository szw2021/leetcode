package lint18;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new ArrayList<>(),res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> set, List<List<Integer>> res) {
        res.add(new ArrayList<>(set));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            set.add(nums[i]);
            dfs(nums, i + 1, set, res);
            set.remove(set.size() - 1);
        }
    }
}