package leetcode.round_1.problem201;

/**
 * 289. Game of Life
 */
public class Solution289 {
    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        if (n == 0) return;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                judge(board, m, n, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private static void judge(int[][] board, int m, int n, int i, int j) {
        int count0 = 0, count1 = 0;
        for (int k = Math.max(0, i - 1); k <= Math.min(m - 1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(n - 1, j + 1); l++) {
                if ((k != i || l != j) && (1 & board[k][l]) == 1) count1++;
            }
        }
        if (board[i][j] == 0) {
            // 00
            if (count1 == 3) board[i][j] = 2; // 10
        } else {
            // 01
            if (count1 == 2 || count1 == 3) board[i][j] = 3; // 11
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 0, 1}};
        gameOfLife(board);

        int[][] board1 = new int[][]{{0}};
        gameOfLife(board1);

        int[][] board2 = new int[][]{{}};
        gameOfLife(board2);
    }

}
