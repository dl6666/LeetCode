package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {

	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null) {
            return res;
        }
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        helper (res, map, new StringBuffer(), 0, digits);
        return res;
    }
    private void helper (List<String> res, HashMap<Character, char[]> map, StringBuffer sb, int index, String digits) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            for (char c : map.get(digits.charAt(index))) {
                sb.append(c);
                helper (res, map, sb, index + 1, digits);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
