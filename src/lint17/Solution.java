package lint17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
