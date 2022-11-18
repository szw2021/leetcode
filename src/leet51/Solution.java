package leet51;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(chess, res, 0);
        return res;
    }

    private void dfs(char[][] chess, List<List<String>> res, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }

        for (int i = 0; i < chess[0].length; i++) {
            if (isValid(chess, row, i)) {
                chess[row][i] = 'Q';
                dfs(chess, res, row + 1);
                chess[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] chess, int row, int col) {
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; j >= 0 && i >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >=  0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            res.add(new String(chess[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveNQueens(4));
    }
}
