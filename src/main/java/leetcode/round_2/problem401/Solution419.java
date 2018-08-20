package leetcode.round_2.problem401;

/**
 * 419. Battleships in a Board
 */
public class Solution419 {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            int pre = -2;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (j - pre > 1 && (i == 0 || board[i - 1][j] != 'X')) {
                        count++;
                    }
                    pre = j;
                }
            }
        }
        return count;
    }
}
