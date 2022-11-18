package lint135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:     An integer
     * @return: A list of lists of integers
     * we will sort your return value in output
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int startIndex, int remainNumber, List<Integer> subset, List<List<Integer>> res) {
        if (remainNumber == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (remainNumber < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            subset.add(candidates[i]);
            dfs(candidates, i, remainNumber - candidates[i], subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}