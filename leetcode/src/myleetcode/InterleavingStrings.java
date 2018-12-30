package myleetcode;

public class InterleavingStrings {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len1 == 0) return s2.equals(s3);
        if (len2 == 0) return s1.equals(s3);
        //f[i][j] = f[i - 1][j] if (s1[i - 1] == s3[i + j])
        //        = f[i][j - 1] if (s2[j - 1] == s3[i + j])
        //base : f[0][j] = true if s2[j - 1] == s3[j - 1]
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int j = 1; j <= len2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) f[0][j] = true;
            else break;
        }
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) f[i][0] = f[i - 1][0];
            for (int j = 1; j <= len2; j++) {
                f[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]);
            }
        }
        return f[len1][len2];
    }
}
