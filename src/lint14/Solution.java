package lint14;

public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
//        while (start + 1 < end) {
//            int mid = (start + end) / 2;
//            if (nums[mid] == target) {
//                end = mid;
//            } else if (nums[mid] > target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//        if (nums[start] == target) {
//            return start;
//        }
//        if (nums[end] == target) {
//            return end;
//        }
//        return -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
