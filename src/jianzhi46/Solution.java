package jianzhi46;

class Solution {
    public int translateNum(int num) {
        String n = String.valueOf(num);
        int[] dp = new int[n.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= n.length(); i++) {
            dp[i] = dp[i - 1];
            if (i > 1) {
                int tmp = (n.charAt(i - 2) - '0') * 10 + (n.charAt(i - 1) - '0');
                if (tmp >= 10 && tmp <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n.length()];
    }
}