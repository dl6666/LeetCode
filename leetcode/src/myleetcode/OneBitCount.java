package com.dilin.java.practice.imp.problems;

public class OneBitCount {
	public int getCount (int n, int m) {
		int digit = getHigh(m);
		int[] dp = getPowCount(digit);
		return memSearch(m, dp) - memSearch(n - 1,dp);
	}
	public int[] getPowCount(int digit) {
		int[] dp = new int[digit + 1];
		dp[0] = 0;
		for (int i = 1; i <= digit; i++) {
			dp[i] = dp[i - 1] * 2 + (1 << i - 1);
		}
		return dp;
	}
	public int memSearch (int n, int[] dp) {
		if (n <= 0) return 0;
		int digit = getHigh(n);
		int rem = n - (1 << digit);
		if (rem == 0) return dp[digit] + 1;
		return dp[digit] + rem + 1 + memSearch(rem, dp);
	}
	public int getHigh(int m) {
		int i = 0;
		while(1 << i + 1 <= m) {
			i++;
		}
		return i;
	}
}
