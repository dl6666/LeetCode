package myleetcode;

public class DecodeWays {

	public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] f = new int[len + 1];
        //s[i - 1] == 1 f[i] = f[i - 1] + f[i - 2]; s[i - 1] == 2 if (s[i] 1 ~ 6) then f[i] = f[i - 1] + f[i - 2],else f[i] = f[i - 1]
        f[0] = 1;
        if (s.charAt(0) != '0') f[1] = f[0];
        char pre = s.charAt(0);
        for (int i = 2; i <= len; i++) {
            char curt = s.charAt(i - 1);
            if (curt == '0') {
                if (pre == '1' || pre == '2') {
                    f[i] = f[i - 2];
                }
            } else if (pre == '1' || (pre == '2' && curt >= '1' && curt <= '6')) {
                f[i] = f[i - 1] + f[i - 2];
            } else {
                f[i] = f[i - 1];
            }
            pre = curt;
        }
        return f[len];
    }
}
