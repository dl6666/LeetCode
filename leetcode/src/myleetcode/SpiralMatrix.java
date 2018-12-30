package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        int row = matrix.length, col = matrix[0].length, min = Math.min(row, col), layer = min / 2;
        for (int k = 0; k < layer; k++) {
            //two rows and two cols
            for (int i = k; i < col - k - 1; i++) {
                res.add(matrix[k][i]);
            }
            for (int i = k; i < row -k - 1; i++) {
                res.add(matrix[i][col - k - 1]);
            }
            for (int i = col - k - 1; i > k; i--) {
                res.add(matrix[row - k - 1][i]);
            }
            for (int i = row - k - 1; i > k; i--) {
                res.add(matrix[i][k]);
            }
        }
        if (min % 2 != 0) {
            if (row >= col) {
                for (int j = col / 2; j < row - col / 2; j++) {
                    res.add(matrix[j][col / 2]);
                }
            } else {
                for (int i = row / 2; i < col - row / 2; i++) {
                    res.add(matrix[row / 2][i]);
                }
            }
        }
        return res;
    }
}
