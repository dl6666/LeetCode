package com.dilin.java.practice.myLeetCode;

public class DistinctSubsequence {

	public int numDistinct(String S, String T) {
        int lenS = S.length(), lenT = T.length();
        int[][] f = new int[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) {
            f[i][0] = 1;
        }
        for (int j = 1; j <= lenT; j++) {
            for (int i = j; i <= lenS; i++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[lenS][lenT];
    }
}
