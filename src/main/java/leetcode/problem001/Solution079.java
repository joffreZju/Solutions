package leetcode.problem001;

/**
 * Created by joffre on 2017/10/28.
 * 79. Word Search
 */
public class Solution079 {
    private static int m, n;

    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(i, j, 0, board, word))
                    return true;
        return false;
    }

    private static boolean dfs(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return false;
        board[i][j] ^= 256;
        int[][] locs = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
        for (int[] loc : locs)
            if (dfs(loc[0], loc[1], index + 1, board, word)) {
                board[i][j] ^= 256;
                return true;
            }

        board[i][j] ^= 256;
        return false;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board, "ABCCFB"));
    }
}
