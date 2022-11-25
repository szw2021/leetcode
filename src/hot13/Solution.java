package hot13;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return res;
    }

    private void dfs(int left, int right, int n, String str) {
        if (right == n) {
            res.add(str);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, str + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, str + ")");
        }
    }
}
