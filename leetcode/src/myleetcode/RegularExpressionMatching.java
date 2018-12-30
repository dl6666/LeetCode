package com.dilin.java.practice.myLeetCode;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
        //dp : f[i][j] first i of s and first j of p match
        //if (p[j] == '.' || s[i] == p[j]) f[i][j] = f[i - 1][j - 1] bound f[0][0] = true
        //else if (p[j] == '*') f[i][j] = true when f[i][j - 2] = true || ((p[j] == '.' && has one f[0 ~ i][j - 2] = true)  || (has all till kth s[i ~ k] == p[j - 1] && f[k - 1][j - 2])) boundary 
        int lenS = s.length(), lenP = p.length();
        boolean[][] f = new boolean[lenS + 1][lenP + 1];
        f[0][0] = true;
        for (int j = 2; j <= lenP; j += 2) {
            if (p.charAt(j - 1) == '*' && f[0][j - 2]) {
                f[0][j] = true;
            }
        }
        for (int i = 1; i <= lenS; i++) {
            char curtS = s.charAt(i - 1);
            for (int j = 1; j <= lenP; j++) {
                char curtP = p.charAt(j - 1);
                if (curtP == '.' || curtS == curtP) {
                    if (f[i - 1][j - 1]) {
                        f[i][j] = true;
                    }
                } else if (curtP == '*' && j != 1) {
                    if (p.charAt(j - 2) == '.') {
                        for (int k = i; k >= 0; k--) {
                            if (f[k][j - 2]) {
                                f[i][j] = true;
                                break;
                            }
                        }
                    } else {
                        if (f[i][j - 2]) {
                            f[i][j] = true;
                        } else {
                            for (int k = i; k > 0 && s.charAt(k - 1) == p.charAt(j - 2); k--) {
                                if (f[k - 1][j - 2]) {
                                    f[i][j] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return f[lenS][lenP];
    }
}
