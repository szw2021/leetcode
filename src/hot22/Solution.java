package hot22;

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                //todo
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int i = 0; i < m; i++) {
            reverse(matrix, i);
        }
    }

    private void reverse(int[][] matrix, int row) {
        int[] t = matrix[row];
        for (int i = 0, j = t.length - 1; i < j; i++, j--) {
            int temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
    }
}
