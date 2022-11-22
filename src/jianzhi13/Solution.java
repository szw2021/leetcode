package jianzhi13;

class Solution {
    int res = 0;
    boolean[][] flag;
    public int movingCount(int m, int n, int k) {
        flag = new boolean[m][n];
        dfs(m, n, k, 0, 0);
        return res;
    }

    private void dfs(int m, int n, int k, int x, int y) {
        res += 1;
        flag[x][y] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && (sum(newX) + sum(newY) <= k) && flag[newX][newY] == false) {
                System.out.println("x" + newX + "y" + newY);
                dfs(m, n, k, newX, newY);
            }
        }
    }

    private int sum(int val) {
        int res = 0;
        while (val != 0) {
            res += (val % 10);
            val = val / 10;
        }
        return res;
    }
}
