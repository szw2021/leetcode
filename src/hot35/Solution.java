package hot35;

class Solution {
    //todo
    boolean res = false;
    boolean[][] flag;
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                dfs(board, word, i, j, 0);
            }
        }
        return res;
    }

    private void dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length() - 1) {
            if (word.charAt(index) == board[x][y]) {
                res = true;
            }
            return;
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        if (word.charAt(index) == board[x][y]) {
            flag[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && flag[newX][newY] == false) {
                    dfs(board, word, newX, newY, index + 1);
                }
            }
            flag[x][y] = false;
        }
    }


}