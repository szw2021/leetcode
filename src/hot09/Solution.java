package hot09;

import java.util.ArrayList;
import java.util.List;

//todo dfs
class Solution {
    String[] strs = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }

    public void dfs(String digits, int u, String path) {
       if (u == digits.length()) {
           res.add(path);
           return;
       }
       int index = digits.charAt(u) - '0';
        for (Character c : strs[index].toCharArray()) {
            dfs(digits, u + 1, path + c);
       }
    }
}
