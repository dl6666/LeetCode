package com.dilin.java.practice.myLeetCode;

public class StringToInteger {

	public int atoi(String str) {
        str = str.trim();
        int i = 0, res = 0, len = str.length();
        if (len == 0) return res;
        boolean pos = true;
        if (str.charAt(i) == '-') {
            pos = false;
            i++;
        } else if (str.charAt(i) == '+') i++;
        while(i < len) {
            char curt = str.charAt(i);
            if (curt > '9' || curt < '0') {
                break;//instead of return directly
            } else {
                int val = curt - '0';
                if (pos && (Integer.MAX_VALUE / 10 < res || (res == Integer.MAX_VALUE / 10 && (val >= Integer.MAX_VALUE % (Integer.MAX_VALUE / 10))))) {
                    return Integer.MAX_VALUE;
                } else if (!pos && (Integer.MAX_VALUE / 10 < res || (res == Integer.MAX_VALUE / 10 && (val >= Integer.MAX_VALUE % (Integer.MAX_VALUE / 10) + 1)))){
                    return Integer.MIN_VALUE;
                } else {
                    res *= 10;
                    res += val;
                }
            }
            i++;
        }
        return pos ? res : -res;
    }
}
