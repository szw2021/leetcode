package jianzhi29;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        boolean[][] flag = new boolean[m][n];
        int x = 0, y = 0;
        int index = 0;
        for (int i = 0; i < m * n; i++) {
            System.out.println("x" + x + "y " + y);
            res[i] = matrix[x][y];
            System.out.println(res[i]);
            flag[x][y] = true;
            int newX = x + dx[index];
            int newY = y + dy[index];
            if (newX < 0 || newX >= m || newY < 0 || newY >=n || flag[newX][newY] == true) {
                index = (index + 1) % 4;
                newX = x + dx[index];
                newY = y + dy[index];
            }
            x = newX;
            y = newY;
        }
        return res;
    }
}
