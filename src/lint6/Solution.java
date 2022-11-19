package lint6;
public class Solution {
    /**
     * @param a: sorted integer array A
     * @param b: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] a, int[] b) {
        // write your code here
        int [] res = new int[a.length + b.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[index++] = a[i++];
            } else {
                res[index++] = b[j++];
            }
        }
        while (i < a.length) {
            res[index++] = a[i++];
        }
        while (j < b.length) {
            res[index++] = b[j++];
        }
        return res;
    }
}
