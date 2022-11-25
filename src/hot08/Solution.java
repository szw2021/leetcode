package hot08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int t = nums[l] + nums[r] + nums[i];
                if (t == 0) {
                    res.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (t < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}