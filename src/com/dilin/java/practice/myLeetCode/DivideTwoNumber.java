package com.dilin.java.practice.myLeetCode;

public class DivideTwoNumber {

	public int divide(int dividend, int divisor) {
        int res = 0;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        } else if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                dividend += divisor;
            } else {
                dividend -= divisor;
            }
            res++;
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        boolean pos = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            pos = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int i = 0;
            while (dividend >> i + 1 >= divisor) {
                i++;
            }
            res += 1 << i;
            dividend -= divisor << i;
        }
        return pos ? res : -res;
    }
}
