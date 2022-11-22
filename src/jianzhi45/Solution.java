package jianzhi45;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String minNumber(int[] nums) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        n = nums.length;

        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int j : list) {
            s += j;
        }
        return s;
    }
}
