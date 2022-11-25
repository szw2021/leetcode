package hot18;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int left = -1, right = -1;
        if (nums[end] == target) {
            left = end;
        }

        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (nums[end] == target) {
            right = end;
        }
        return new int[]{left, right};
    }
}
