package myleetcode;

public class TrappingRain {
	public int trap(int[] A) {
        if (A == null) return 0;
        int len = A.length;
        if (len <= 2) return 0;
        int[] left = new int[len];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            left[i] = max;
            if (max < A[i]) max = A[i];
        }
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            int min = Math.min(left[i], max);
            sum += min > A[i] ? min - A[i] : 0;
            if (max < A[i]) max = A[i];
        }
        return sum;
    }
}
