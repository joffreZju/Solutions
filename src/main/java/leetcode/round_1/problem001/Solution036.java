package leetcode.round_1.problem001;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joffre on 2017/10/10.
 * 36. Valid Sudoku
 */
public class Solution036 {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        char cur;
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                cur = board[i][j];
                if (cur == '.') continue;
                else if (set.contains(cur)) return false;
                else set.add(cur);
            }
        }
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                cur = board[j][i];
                if (cur == '.') continue;
                else if (set.contains(cur)) return false;
                else set.add(cur);
            }
        }
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                set.clear();
                for (int i = y; i < y + 3; i++) {
                    for (int j = x; j < x + 3; j++) {
                        cur = board[i][j];
                        if (cur == '.') continue;
                        else if (set.contains(cur)) return false;
                        else set.add(cur);
                    }
                }
            }
        }

        return true;
    }

}
