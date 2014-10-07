package com.dilin.java.practice.myLeetCode;

public class ReverseWordsInString {

	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        StringBuffer sb = new StringBuffer();
    	for (int i = len - 1; i >= 0; i--) {
    	    while (i >=0 && s.charAt(i) == ' ') i--;
    	    if (i == -1) continue;
    	    int end = i;
    	    while (i >= 0 && s.charAt(i) != ' ') i--;
    	    sb.append(s.substring(i + 1, end + 1));
    	    sb.append(" ");
    	}
    	return sb.length() == 0 ? "" : sb.toString().substring(0, sb.length() - 1);
    }
}
