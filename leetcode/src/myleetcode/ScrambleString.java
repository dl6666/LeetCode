package myleetcode;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] f = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    f[i][j][1] = true;
                }
            }
        }
        for (int k = 2; k <= len; k++) {
            for (int i = k - 1; i < len; i++) {
                for (int j = k - 1; j < len; j++) {
                    for (int l = 1; l < k; l++) {
                        if ((f[i][j][l] && f[i - l][j - l][k - l]) || (f[i][j - k + l][l] && f[i - l][j][k - l])) {
                            f[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[len - 1][len - 1][len];
    }
}
