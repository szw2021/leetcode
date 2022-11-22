package jianzhi42;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int res = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
            if (dp[i] > res) {
                res = nums[i];
            }
        }
        return res;
    }
}
