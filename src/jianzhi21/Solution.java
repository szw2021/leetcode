package jianzhi21;

class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right++;
            }
            if (left < right) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right--;
            }
        }
        return nums;
    }
}