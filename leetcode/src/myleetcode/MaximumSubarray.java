package myleetcode;

public class MaximumSubarray {

	public int maxSubArray(int[] A) {
        int sum = 0, len = A.length, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += A[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
