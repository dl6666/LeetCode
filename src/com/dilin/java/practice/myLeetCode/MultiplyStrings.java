package com.dilin.java.practice.myLeetCode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        char[] number1 = num1.toCharArray(), number2 = num2.toCharArray();
        int[] res = new int[len1 + len2 + 1];
        int len = res.length;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int prod = (number1[i] - '0') * (number2[j] - '0');
                res[i + j + 2] += prod;
                res[i + j + 1] += res[i + j + 2] / 10;
                res[i + j + 2] %= 10;
            }
        }
        if (len1 != 0 || len2 != 0) {
            res[0] += res[1] / 10;
            res[1] %= 10;
        }
        int i = 0;
        for (; i < len; i++) {
            if (res[i] != 0) {
                break;
            }
        }
        if (i == len) return "0";
        StringBuffer sb = new StringBuffer();
        for (; i < len; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
