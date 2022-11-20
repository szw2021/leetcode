package lint585;

public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (nums[mid - 1] < nums[mid]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
