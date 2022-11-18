package lint153;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     *          we will sort your return value in output
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        dfs(num, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] num, int startIndex, int remainNumber, List<Integer> subset, List<List<Integer>> res) {
        if (remainNumber == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (remainNumber < 0) {
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            subset.add(num[i]);
            dfs(num, i + 1, remainNumber - num[i], subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
