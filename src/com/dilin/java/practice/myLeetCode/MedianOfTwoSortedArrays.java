package com.dilin.java.practice.myLeetCode;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len == 0) return 0.0;
        if (len % 2 == 0) {
            return (findKth(A, B, 0, 0, len / 2) + findKth(A, B, 0, 0, len / 2 + 1)) / 2.0;
        } else {
            return 1.0 * findKth(A, B, 0, 0, len / 2 + 1);
        }
    }
    private int findKth (int A[], int B[], int AStart, int BStart, int k) {
        if (AStart >= A.length) {
            return B[BStart + k - 1];
        }
        if (BStart >= B.length) {
            return A[AStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[AStart], B[BStart]);// forget about it 
        }
        int AHalf = AStart + k / 2 - 1 < A.length ? A[AStart + k / 2 - 1] : Integer.MAX_VALUE;
        int BHalf = BStart + k / 2 - 1 < B.length ? B[BStart + k / 2 - 1] : Integer.MAX_VALUE;
        if (AHalf > BHalf) {
            return findKth (A, B, AStart, BStart + k / 2, k - k / 2);
        } else {
            return findKth (A, B, AStart + k / 2, BStart, k - k/ 2);
        }
    }
}
