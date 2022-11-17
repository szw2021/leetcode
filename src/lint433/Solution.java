package lint433;

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j]) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] grid, int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        grid[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == true) {
                dfs(grid, newX, newY);
            }
        }
    }
}
