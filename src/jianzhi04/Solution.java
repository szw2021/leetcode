package jianzhi04;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while (m  < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            }
            if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
