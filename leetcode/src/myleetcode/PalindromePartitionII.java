package myleetcode;

public class PalindromePartitionII {

	public int minCut(String s) {
        int len  = s.length();
        int[] f = new int[len + 1];
        f[0] = -1;
        boolean[][] p = findPalindrome(s);
        for (int i = 1; i <= len; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (p[j - 1][i - 1]) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
            f[i]++;
        }
        return f[len];
    }
    private boolean[][] findPalindrome(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            f[i][i] = true;
        }
        for (int i = 0; i < len  - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1]= true;
            }
        }
        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                if (s.charAt(i) == s.charAt(i + k - 1) && f[i + 1][i + k - 2]) {
                    f[i][i + k - 1] = true;
                }
            }
        }
        return f;
    }
}
