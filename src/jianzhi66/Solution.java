package jianzhi66;

class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }

        int[] b = new int[len];
        for (int i = 0, p = 1; i < len; i++) {
            b[i] = p;
            p = p * a[i];
        }

        for (int i = len - 1, p = 1; i >= 0; i--) {
            b[i] *= p;
            p = p * a[i];
        }
        return b;
    }
}
