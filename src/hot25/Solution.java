class Solution {
    public boolean canJump(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        flag[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                continue;
            }
            int k = nums[i];
            for (int j = 1; j <= k; j++) {
                if (j + i < flag.length)
                    flag[j + i] = true;
            }
        }
        return flag[nums.length - 1];
    }
}