package com.dilin.java.practice.myLeetCode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        //must calculate from the last digits
        int len1 = num1.length(), len2 = num2.length();
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int[] n = new int[len1 + len2];
        StringBuffer sb = new StringBuffer();
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int curt = (n1[i] - '0') * (n2[j] - '0');
                n[i + j + 1] += curt;
                n[i + j] += n[i + j + 1] / 10;
                n[i + j + 1] %= 10;
            }
        }
        int i = 0;
        while (i < len1 + len2 && n[i] == 0) i++;
        while (i < len1 + len2) {
            sb.append(n[i]);
            i++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
