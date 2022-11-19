package lint138;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        int[] preSum = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        preSum[0] = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (map.containsKey(preSum[i])) {
                res.add(map.get(preSum[i]));
                res.add(i - 1);
                return res;
            }
            map.put(preSum[i], i);
        }
        return res;
    }
}