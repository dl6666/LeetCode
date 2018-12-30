package com.dilin.java.practice.myLeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
        int pre = 0, len = s.length(), res = 0;
        Map<Character, Integer> map  = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for (int i = len - 1; i >= 0; i--) {
            int curt = map.get(s.charAt(i));
            if (curt >= pre) res += curt;
            else res -= curt;
            pre = curt;
        }
        return res;
    }
}
