package hot19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo startIndex
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int total, int index, int target, List<Integer> list) {
        if (target == total) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (total > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, total + candidates[i], i, target,list);
            list.remove(list.size() - 1);
        }
    }
}
