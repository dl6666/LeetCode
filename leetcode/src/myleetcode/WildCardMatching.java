package myleetcode;

public class WildCardMatching {

	public boolean isMatch(String s, String p) {
        int i = 0, j = 0, lenS = s.length(), lenP = p.length(), sSave = -1, pSave = -1;
        while (i < lenS) {
            if (j == lenP) {
                if (pSave != -1) {
                    sSave++;
                    i = sSave;
                    j = pSave;
                    continue;
                } else {
                    break;
                }
            }
            if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                pSave = j;
                sSave = i;
                j++;
            } else {
                if (pSave == -1) {
                    return false; 
                } else {
                    sSave++;
                    i = sSave;
                    j = pSave;
                }
            }
        }
        while (j < lenP && p.charAt(j) == '*') {
            j++;
        }
        return i == lenS && j == lenP;
    }
}
