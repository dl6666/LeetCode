package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = helper(s, dict, new HashMap<String, List<String>>());
        return res;
    }
    private List<String> helper (String s, Set<String> dict, HashMap<String, List<String>> map) {
        List<String> res = new ArrayList<String>();
        if (s.length() == 0) return res;
        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            if (dict.contains(pre)) {
                if (i == s.length()) {
                    res.add(pre);
                } else {
                    String suf = s.substring(i);
                    List<String> temp = null;
                    if (map.containsKey(suf)) {
                        temp = map.get(suf);
                    } else {
                        temp = helper(s.substring(i), dict, map);
                    }
                    for (String ss : temp) {
                        res.add(pre + " " + ss);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
