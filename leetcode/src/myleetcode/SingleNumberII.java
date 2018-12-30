package com.dilin.java.practice.myLeetCode;

public class SingleNumberII {

	public int singleNumber(int[] A) {
        int[] tri = new int[32];
        for (int i = 0; i < A.length; i++) {
            int curt = A[i];
            for (int j = 0; j < 32; j++) {
                if (((1 << j) & curt) != 0) {
                    tri[j]++;
                    tri[j] %= 3;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (tri[i] != 0) {
                res += (1 << i);
            }
        }
        return res;
    }
}
