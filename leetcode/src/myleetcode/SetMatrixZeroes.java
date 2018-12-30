package myleetcode;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)return;
        int row = matrix.length, col = matrix[0].length;
        boolean[] r = new boolean[row], c = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = c[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            if (r[i]) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < col; j++) {
            if (c[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
