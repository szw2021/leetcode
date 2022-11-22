package jianzhi57;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[2];
    }
}
