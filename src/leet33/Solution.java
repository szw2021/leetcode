package leet33;

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] >= nums[0]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (target >= nums[0]) {
            start = 0;
        } else {
            start = start + 1;
            end = nums.length - 1;
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[end] == target) {//todo 范围
            return end;
        }
        return -1;
    }
}