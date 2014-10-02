package com.dilin.java.practice.myLeetCode;

public class LongestPalindromaticSubstring {

	public String longestPalindrome(String s) {
        int max = 0, len = s.length(), nLen = len * 2, c = 0, start = 0, end = 0;
        if (s == null || s.length() == 0) return s;
        int[] p = new int[nLen];
        for (int i = 0; i < nLen; i++) {
            int ii = c * 2 - i;
            p[i] = c + p[c] > i ? Math.min(c + p[c] - i, p[ii]) : 0;
            while (i - p[i] - 1 >= 0 && i + p[i] + 1<= nLen && getChar(s, i + p[i] + 1) == getChar(s, i - p[i] - 1)) {
                p[i]++;
            }
            if (max < p[i]) {
                start = (i - p[i] + 1) / 2;
                end = (i + p[i] - 1) / 2;
                max = p[i];
            }
            if (i + p[i] > c + p[c]) {
                c = i;
            }
        }
        return s.substring(start, end + 1);
    }
    private char getChar(String s, int i) {
        if (i % 2 == 0) {
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }
}
