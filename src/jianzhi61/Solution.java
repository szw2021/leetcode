package jianzhi61;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isStraight(int[] nums) {
        int min = 13;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (max - min) < 5;
    }
}
