package jianzhi53;

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int left = -1;
        int right = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] == target) {
            left = start;
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

        if (nums[start] == target) {
            right = start;
        }

        if (left == -1) {
            return 0;
        }
        return (right - left + 1);
    }

    public int missingNumber(int[] nums) {
        //todo
        if (nums[nums.length - 1] == nums.length - 1) {
            return nums.length;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] != mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
