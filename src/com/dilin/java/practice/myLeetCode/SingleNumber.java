package com.dilin.java.practice.myLeetCode;

public class SingleNumber {
	public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;
        int res = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            res ^= A[i];
        }
        return res;
    }
}
