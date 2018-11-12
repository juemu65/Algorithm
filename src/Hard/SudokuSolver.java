package Hard;

public class SudokuSolver {
    //37. 解数独
    //编写一个程序，通过已填充的空格来解决数独问题。
    //
    //一个数独的解法需遵循如下规则：
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    //空白格用 '.' 表示。

    boolean[][] r = new boolean[10][10];
    boolean[][] c = new boolean[10][10];
    boolean[][] p = new boolean[10][10];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    r[i + 1][board[i][j] - '0'] = true;
                    c[j + 1][board[i][j] - '0'] = true;
                    p[i / 3 * 3 + j / 3 + 1][board[i][j] - '0'] = true;
                }
            }
        }
        solve(board, 1);
    }

    private boolean solve(char[][] board, int n) {
        while (n <= 81 && board[(n - 1) / 9][(n - 1) % 9] != '.') {
            n++;
        }
        if (n <= 81) {
            int row = (n - 1) / 9;
            int col = (n - 1) % 9;
            for (int i = 1; i < 10; i++) {
                if (r[row + 1][i] || c[col + 1][i] || p[row / 3 * 3 + col / 3 + 1][i]) {
                    continue;
                }
                board[row][col] = (char) ('0' + i);
                r[row + 1][i] = true;
                c[col + 1][i] = true;
                p[row / 3 * 3 + col / 3 + 1][i] = true;
                if (solve(board, n + 1)) {
                    return true;
                }
                board[row][col] = '.';
                r[row + 1][i] = false;
                c[col + 1][i] = false;
                p[row / 3 * 3 + col / 3 + 1][i] = false;
            }
            return false;
        }
        return true;
    }
}
