package hot24;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i - 1];
            } else {
                dp[i] = nums[i - 1];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}