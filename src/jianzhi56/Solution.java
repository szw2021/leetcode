package jianzhi56;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        int m = 1;
        while ((res & m) == 0) {
            m = m << 1;
        }
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) != 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }
        return new int[]{x, y};
    }

    public int singleNumbers1(int[] nums) {
        int[] bits = new int[32];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    bits[j]++;
                }
                num = num / 2;
                j++;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (1 << i) * (bits[i] % 3);
        }
        return ans;
    }
}
