package hot15;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        int j = n - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i == -1) {
            Arrays.sort(nums);
            return;
        }

        int k = n - 1;
        while (k > i && nums[k] <= nums[i]) {
            k--;
        }
        int t = nums[k];
        nums[k] = nums[i];
        nums[i] = t;
        Arrays.sort(nums, j, n);
    }
}
