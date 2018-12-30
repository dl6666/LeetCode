package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithCat {

	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (L == null || S == null) return res;
        int wLen = L[0].length(), LLen = L.length, SLen = S.length();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();//use map instead of set because dup in dict
        for (int i = 0; i < LLen; i++) {
            if (dict.containsKey(L[i])) {
                dict.put(L[i], dict.get(L[i]) + 1);
            } else {
                dict.put(L[i], 1);
            }
        }
        for (int i = 0; i < SLen - wLen * LLen + 1; i++) {
            HashMap<String, Integer> scan = new HashMap<String, Integer>();//use another map to check if count exceeds
            int j = 0;
            for (; j < LLen; j++) {//use a word count scanner to go through all words
                int k = i + j * wLen;
                String curt = S.substring(k, k + wLen);
                if (dict.containsKey(curt)) {
                    if (scan.containsKey(curt)) {
                        scan.put(curt, scan.get(curt) + 1);
                        if (scan.get(curt) > dict.get(curt)) break;//exceeds the limit
                    } else {
                        scan.put(curt, 1);
                    }
                } else {
                    break;//at least not continue
                }
            }
            if (j == LLen) res.add(i);//without break means contains all
        }
        return res;
    }
}
