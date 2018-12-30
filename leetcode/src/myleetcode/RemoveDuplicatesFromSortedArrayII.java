package com.dilin.java.practice.myLeetCode;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int end = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            if (i >=  len - 2 || A[i] != A[i + 2]) {
                A[end] = A[i];
                end++;
            }
        }
        return end;
    }
}
