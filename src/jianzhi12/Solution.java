package jianzhi12;

class Solution {
    boolean[][] flag;
    public boolean exist(char[][] board, String word) {
        flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int index, String word) {

        if (word.charAt(index) != board[x][y]) {
            return false;
        }

        if (word.length() == index + 1) {
            return true;
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        flag[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && flag[newX][newY] == false) {
                if (dfs(board, newX, newY, index + 1, word)) {
                    return true;
                }
            }
        }
        flag[x][y] = false;
        return false;
    }
}
