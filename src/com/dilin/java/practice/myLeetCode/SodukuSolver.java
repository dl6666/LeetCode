package com.dilin.java.practice.myLeetCode;

public class SodukuSolver {
	public void solveSudoku(char[][] board) {
        helper(board, 0, -1);
    }
    private boolean helper (char[][] board, int i, int j) {
        for (int k = i; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                if (board[k][l] == '.') {
                    for (char m = '1'; m <= '9'; m++) {
                        board[k][l] = m;
                        if (isVal(board, k, l)) {
                            if (helper(board, k, l)) {
                                return true;
                            }
                        }
                    }
                    board[k][l] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isVal (char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if ((j != k && board[i][j] == board[i][k]) || (i != k && board[i][j] == board[k][j]) || ((i / 3 * 3 + k / 3 != i || j / 3 * 3 + k % 3 != j) && board[i][j] == board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3]) ) {
                return false;
            }
        }
        return true;
    }
}
