package myleetcode;

import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions {
	public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        Queue<Integer> xQ = new LinkedList<Integer>(), yQ = new LinkedList<Integer>();
        for (int j = 0; j < col; j++) {
        	addNeighbor (board, 0, j, xQ, yQ);
        	addNeighbor (board, row - 1, j, xQ, yQ);
        }
        for (int i = 1; i < row - 1; i++) {
        	addNeighbor (board, i, 0, xQ, yQ);
        	addNeighbor (board, i, col - 1, xQ, yQ);
        }
        while (!xQ.isEmpty()) {
            int xInd = xQ.poll(), yInd = yQ.poll();
            board[xInd][yInd] = 'Y';
            addNeighbor (board, xInd + 1, yInd, xQ, yQ);
            addNeighbor (board, xInd - 1, yInd, xQ, yQ);
            addNeighbor (board, xInd, yInd + 1, xQ, yQ);
            addNeighbor (board, xInd, yInd - 1, xQ, yQ);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void addNeighbor (char[][] board, int xInd, int yInd, Queue<Integer> xQ, Queue<Integer> yQ) {
        if (isVal(board, xInd, yInd)) {
            xQ.offer(xInd);
            yQ.offer(yInd);
        }
    }
    private boolean isVal (char[][] board, int iInd, int jInd) {
        int row = board.length, col = board[0].length;
        return iInd >= 0 && iInd < row && jInd >= 0 && jInd < col && board[iInd][jInd] == 'O';
    }
}
