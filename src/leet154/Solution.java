package leet154;
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end && nums[end] == nums[0]) {
            end--;
        }
        if (nums[end] >= nums[0]) {
            return nums[0];
        }
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[0]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}
