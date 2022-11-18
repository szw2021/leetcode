package lint15;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     *          we will sort your return value in output
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] flag;
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        flag = new boolean[nums.length];
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int n) {
        if (n == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                temp.add(nums[i]);
                dfs(nums, n + 1);
                temp.remove(temp.size() - 1);
                flag[i] = false;
            }
        }
    }
}