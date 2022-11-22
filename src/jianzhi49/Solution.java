package jianzhi49;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int nthUglyNumber(int n) {
        int res = 0;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0, j = 0, k = 0, cnt = 1; cnt < n; cnt++) {
            res = Math.min(f[i] * 2, Math.min(f[j] * 3, f[k] * 5));
            if (f[i] * 2 == res) i++;
            if (f[j] * 3 == res) j++;
            if (f[k] * 5 == res) k++;
            f[cnt] = res;
        }
        return f[n - 1];
    }
}