package leetcode.round_1.problem101;

/**
 * 130. Surrounded Regions
 */
public class Solution130 {
    private static int[][] shift = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') helper(board, 0, i);
            if (board[m - 1][i] == 'O') helper(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private static void helper(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'A';
        for (int k = 0; k < 4; k++)
            helper(board, i + shift[k][0], j + shift[k][1]);
    }
}
