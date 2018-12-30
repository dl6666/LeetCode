package com.dilin.java.practice.myLeetCode;

public class SortColor {

	public void sortColors(int[] A) {
        int zero = 0, one = 0;
        for(int i = 0; i < A.length; i++) {
            int temp = A[i];
            A[i] = 2;
            if (temp == 0) {
                A[one] = 1;
                one++;
                A[zero] = 0;
                zero++;
            } else if (temp == 1) {
                A[one] = 1;
                one++;
            }
        }
    }
}
