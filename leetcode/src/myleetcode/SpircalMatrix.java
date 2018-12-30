package myleetcode;

public class SpircalMatrix {

	public int[][] generateMatrix(int n) {
        int level = n / 2, num = 1;
        int[][] res = new int[n][n];
        for (int i = 0; i < level; i++) {
            for (int j = i; j < n - i - 1; j++) res[i][j] = num++;
            for (int j = i; j < n - i - 1; j++) res[j][n - 1 - i] = num++;
            for (int j = i; j < n - i - 1; j++) res[n - 1 - i][n - 1 - j] = num++;
            for (int j = i; j < n - i - 1; j++) res[n - 1 - j][i] = num++;
        }
        if (n % 2 != 0) {
            res[n / 2][n / 2] = num;
        }
        return res;
    }
}
