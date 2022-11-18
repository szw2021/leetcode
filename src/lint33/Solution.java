package lint33;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: The number of queens
     * @return: All distinct solutions
     *          we will sort your return value in output
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        char[][] cheeses = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cheeses[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(cheeses, 0, res);
        return res;
    }

    private void dfs(char[][] cheeses, int row, List<List<String>> res) {
        if (row == cheeses.length) {
            res.add(draw(cheeses));
            return;
        }

        for (int i = 0; i < cheeses[0].length; i++) {
            if (isValid(cheeses, row, i)) {
                cheeses[row][i] = 'Q';
                dfs(cheeses, row + 1, res);
                cheeses[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] cheeses, int row, int col) {
        for (int i = 0; i < cheeses.length; i++) {
            if (cheeses[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (cheeses[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < cheeses[0].length; i--, j++) {
            if (cheeses[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> draw(char[][] cheeses) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < cheeses.length; i++) {
            row.add(new String(cheeses[i]));
        }
        return row;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}
