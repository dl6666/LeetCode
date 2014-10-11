package com.dilin.java.practice.myLeetCode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int index = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] != elem) {
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}
