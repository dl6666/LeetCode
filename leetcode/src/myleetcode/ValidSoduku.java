package myleetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSoduku {
	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<Character>();
            Set<Character> cols = new HashSet<Character>();
            Set<Character> cell = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char curt = board[i][j];
                if (curt <= '9' && curt >= '1') {
                    if (rows.contains(curt)) {
                        return false;
                    } else {
                        rows.add(curt);
                    }
                }
                curt = board[j][i];
                if (curt <= '9' && curt >= '1') {
                    if (cols.contains(curt)) {
                        return false;
                    } else {
                        cols.add(curt);
                    }
                }
                int row = i / 3 * 3 + j / 3, col = i % 3 * 3 + j % 3;
                curt = board[row][col];
                if (curt <= '9' && curt >= '1') {
                    if (cell.contains(curt)) {
                        return false;
                    } else {
                        cell.add(curt);
                    }
                }
            }
        }
        return true;
    }
}
