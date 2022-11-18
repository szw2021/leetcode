package lint16;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> temp = new ArrayList<>();
    boolean[] flag;
    /**
     * @param nums: A list of integers
     * @return: A list of unique permutations
     *          we will sort your return value in output
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        flag = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, flag, results);
        return results;
    }

    private void dfs(int[] nums, boolean[] flag, List<List<Integer>> results) {
        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                if (i > 0 && nums[i] == nums[i - 1] && flag[i - 1] == true) {
                    continue;
                }

                flag[i] = true;
                temp.add(nums[i]);
                dfs(nums, flag, results);
                temp.remove(temp.size() - 1);
                flag[i] = false;
            }
        }
    }
}
