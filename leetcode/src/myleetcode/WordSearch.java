package com.dilin.java.practice.myLeetCode;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ( board[i][j] == word.charAt(0) ) {
                    if (helper (board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper (char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        int len  = word.length(), row = board.length, col = board[0].length;
        if (index == len) {
            return true;
        }
        if (i < 0 || i >= row || j >= col || j < 0 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean  res = helper (board, i - 1, j, word, index + 1, visited) || helper (board, i + 1, j, word, index + 1, visited) || helper (board, i, j - 1, word, index + 1, visited) || helper (board, i, j + 1, word, index + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
