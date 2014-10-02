package com.dilin.java.practice.myLeetCode;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {
        if (S == null || T == null) return "";
        HashMap<Character, Integer> save = new HashMap<Character, Integer>(), scan = new HashMap<Character, Integer>();
        int count = 0, target = 0, lenS = S.length(), lenT = T.length(), min = Integer.MAX_VALUE, startS = -1, endS = -1;
        for (int i = 0; i < lenT; i++) {
            char curt = T.charAt(i);
            if (save.containsKey(curt)) {
                save.put(curt, save.get(curt) + 1);
            } else {
                save.put(curt, 1);
                scan.put(curt,0);
            }
            target++;
        }
        int start = 0, end = 0;
        while (end < lenS) {
            char curt = S.charAt(end);
            if (save.containsKey(curt)) {
                if (scan.get(curt) < save.get(curt)) {
                    count++;
                }
                scan.put(curt, scan.get(curt) + 1);
            }
            while (count == target && start <= end) {
                if (min > end - start + 1) {
                    startS = start;
                    endS = end;
                    min = end - start + 1;
                }
                char curtS = S.charAt(start);
                if (save.containsKey(curtS)) {
                    if (save.get(curtS) >= scan.get(curtS)) {
                        count--;
                    }
                    scan.put(curtS, scan.get(curtS) - 1);
                }
                start++;
            }
            end++;
        }
        if (startS != -1 && endS != -1) {
            return S.substring(startS, endS + 1);
        } else {
            return "";
        }
    }
}
