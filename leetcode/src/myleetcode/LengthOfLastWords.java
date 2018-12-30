package com.dilin.java.practice.myLeetCode;

public class LengthOfLastWords {

	public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0) {
                if (s.charAt(i) != ' ') {
                    length++;
                }
            } else {
                if (s.charAt(i) == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }
        return length;
    }
}
