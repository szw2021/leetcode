package hot16;

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                } else {

                }
            }
        }
    }
}