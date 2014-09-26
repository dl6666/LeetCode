package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String curt = strs[i];
            String countedCurt = countLetters(curt);
            if (map.containsKey(countedCurt)) {
                map.get(countedCurt).add(curt);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(curt);
                map.put(countedCurt, temp);
            }
        }
        List<String> res = new ArrayList<String>();
        Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, List<String>> curtEntry = it.next();
            if (curtEntry.getValue().size() > 1) {
                res.addAll(curtEntry.getValue());
            }
        }
        return res;
    }
    public String countLetters (String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            if (array[i] > 0) {
                char curtChar = (char) ('a' + i);
                sb.append(curtChar);
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}
