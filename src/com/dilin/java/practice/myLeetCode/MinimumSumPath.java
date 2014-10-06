package com.dilin.java.practice.myLeetCode;

public class MinimumSumPath {

	public int minPathSum(int[][] grid) {
        //dp : f[i][j] the min path to i, j
        //min{f[i - 1][j], f[i][j - 1]} + grid[i][j]
        int row = grid.length, col = grid[0].length;
        if (row == 0) return 0;
        int[] f = new int[col];
        f[0] = grid[0][0];
        for (int j = 1; j < col; j++) {
            f[j] = f[j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            f[0] += grid[i][0];
            for (int j = 1; j < col; j++) {
                f[j] = Math.min(f[j], f[j - 1]) + grid[i][j];
            }
        }
        return f[col - 1];
    }
}
