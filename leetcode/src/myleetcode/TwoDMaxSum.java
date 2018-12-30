package myleetcode;

public class TwoDMaxSum {
	public static void main(String[] args) {
		System.out.println(maxRect(new int[][] {{-1,2,3,4},{-4,5,-1,7}}));
	}
	public static int maxRect(int[][] grid) {
		int max = Integer.MIN_VALUE, row = grid.length, col = grid[0].length;
		int[][] f = new int[col][col];
		int[] s = new int[col];
		//f[i][j] the sum between i and j bounded in row k and possiblly row 0
		for (int k = 0; k < row; k++) {
			int sum = 0;
			for (int i = 0; i < col; i++) {
				sum += grid[k][i];
				s[i] = sum;
				f[0][i] += s[i];
				max = Math.max(f[0][i], max);
				if (f[0][i] < 0) f[0][i] = 0;
			}
			for (int i = 1; i < col; i++) {
				for (int j = i; j < col; j++) {
					int sumRange = s[j] - s[i - 1]; 
					f[i][j] += sumRange;
					max = Math.max(max, f[i][j]);
					if (f[i][j] < 0) f[i][j] = 0;
				}
			}
		}
		return max;
	}
}
