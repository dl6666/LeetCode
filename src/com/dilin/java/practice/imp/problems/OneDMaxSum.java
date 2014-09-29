package com.dilin.java.practice.imp.problems;

public class OneDMaxSum {
	public int maxSum (int[] n) {
		int len = n.length, sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			sum += n[i];
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

}
