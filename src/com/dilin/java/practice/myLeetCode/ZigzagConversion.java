package com.dilin.java.practice.myLeetCode;

public class ZigzagConversion {

	public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        int perLoop = nRows * 2 - 2, len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
            int index = perLoop - 2 * i;
            for (int j = i; j < len; j += perLoop) {
                sb.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + index < len) {
                    sb.append(s.charAt(j + index));
                } 
            }
        }
        return sb.toString();
    }
}
