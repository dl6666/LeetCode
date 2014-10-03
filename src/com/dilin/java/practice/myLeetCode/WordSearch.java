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
                    visited[i][j] = true;
                    if (helper (board, i, j, word, 0, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean helper (char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        int len  = word.length(), row = board.length, col = board[0].length;
        if (index == len - 1) {
            return true;
        }
        if (i > 0 && !visited[i - 1][j] && word.charAt(index + 1) == board[i - 1][j]) {
            visited[i - 1][j] = true;
            if (helper (board, i - 1, j, word, index + 1, visited)) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        if (j > 0 && !visited[i][j - 1] && word.charAt(index + 1) == board[i][j - 1]) {
            visited[i][j - 1] = true;
            if (helper (board, i, j - 1, word, index + 1, visited)) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        if (i < row - 1 && !visited[i + 1][j] && word.charAt(index + 1) == board[i + 1][j]) {
            visited[i + 1][j] = true;
            if (helper (board, i + 1, j, word, index + 1, visited)) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        if (j < col - 1 && !visited[i][j + 1] && word.charAt(index + 1) == board[i][j + 1]) {
            visited[i][j + 1] = true;
            if (helper (board, i, j + 1, word, index + 1, visited)) {
                return true;
            }
            visited[i][j + 1] = false;
        }
    
        return false;
    }
}
