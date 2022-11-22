package jianzhi43;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public int translateNum(int num) {
        List<Integer> nums = new ArrayList<>();
        int n = num;
        while (n != 0) {
            nums.add(n % 10);
            n = n / 10;
        }
        int res = 0;
        Collections.reverse(nums);
        for (int i = 0; i < nums.size(); i++) {
            int d = nums.get(i);
            int left = 0, right = 0, p = 1;
            for (int j = 0; j < i; j++) {
                left = left * 10 + nums.get(j);
            }
            for (int j = i + 1; j < nums.size(); j++) {
                right = right * 10 + nums.get(j);
                p = p * 10;
            }
            if (d == 0) {
                res += left * p;
            } else if (d == 1) {
                res += left * p + right + 1;
            } else {
                res += (left + 1) * p;
            }
        }
        return res;
    }
}
