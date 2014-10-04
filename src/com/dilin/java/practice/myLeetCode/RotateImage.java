package com.dilin.java.practice.myLeetCode;

public class RotateImage {

	public void rotate(int[][] matrix) {
        int n = matrix.length, level = n / 2;
        for (int i = 0; i < level; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}