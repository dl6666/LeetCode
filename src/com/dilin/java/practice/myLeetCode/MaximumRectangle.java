package com.dilin.java.practice.myLeetCode;

import java.util.Stack;

public class MaximumRectangle {

	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[] hist = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    hist[j]++;
                } else {
                    hist[j] = 0;
                }
            }
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= col; j++) {
                int height = j == col ? 0 : hist[j];
                while (!stack.isEmpty() && hist[stack.peek()] > height) {
                    int index = stack.pop();
                    int area = stack.isEmpty() ? hist[index] * j : (j - stack.peek() - 1) * hist[index];
                    max = Math.max(area, max);
                }
                stack.push(j);
            }
        }
        return max;
    }
}
