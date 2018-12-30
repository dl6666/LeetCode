package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public List<List<String>> partition(String s) {
        boolean[][] f = isPalindrome(s);
        List<List<String>> res = new ArrayList<List<String>>();
        helper(s, f, new ArrayList<String>(), 0, res);
        return res;
    }
    private void helper (String s, boolean[][] f, List<String> temp, int start, List<List<String>> res) {
        int len = s.length();
        if (start == len) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = start; i < len; i++) {
            if(f[start][i]) {
                temp.add(s.substring(start, i + 1));
                helper(s, f, temp, i + 1, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean[][] isPalindrome(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        for (int i = 1; i < len * 2; i++) {
            int rad = 1;
            while (i - rad >= 0 && i + rad <= len * 2 && getChar(s, i - rad) == getChar(s, i + rad)) {
                if ((i + rad) % 2 == 0) { //not so strict, but the pollutant elements are not used in the construction, because we search only i >= start
                    f[(i - rad + 1) / 2][(i + rad - 1) / 2] = true;
                }
                rad++;
            }
        }
        return f;
    }
    private char getChar(String s, int i) {
        if (i > s.length() * 2) {
            return ' ';
        }
        if (i % 2 == 0) {
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }
}
