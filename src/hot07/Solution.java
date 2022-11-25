package hot07;

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        for (int i = 0, j = n - 1; i < j; ) {
            res = Math.max(Math.min(height[i], height[j]) * (j - i), res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
