package lint136;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return  res;
        }

        List<String> combination = new ArrayList<>();
        dfs(s, 0, combination, res);
        return res;
    }

    private void dfs(String s, int index, List<String> combination, List<List<String>> results) {
        if (index == s.length()) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            combination.add(substring);
            dfs(s, i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0,j = s.length() - 1; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}