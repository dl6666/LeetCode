package com.dilin.java.practice.myLeetCode;

public class SearchInRotatedII {

	public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[start] < A[mid]) {
                if (A[start] <= target && A[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[start] > A[mid]) {
                if (A[end] >= target && A[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }
        if (A[start] == target || A[end] == target) return true;
        return false;
    }
}
