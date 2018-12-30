package myleetcode;

public class MaximumProd {
	public int maxProduct(int[] A) {
        //if negative to save the possible maxProd for the later, should also save the minProd
        int minProd = 1, maxProd = 1, max =Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int curtMinProd = minProd * A[i];
            int curtMaxProd = maxProd * A[i];
            maxProd = max3(curtMinProd, curtMaxProd, A[i]);
            minProd = min3(curtMinProd, curtMaxProd, A[i]);
            max = Math.max(max, maxProd);
        }
        return max;
    }
    private int min3(int val1, int val2, int val3) {
        int temp = Math.min(val1, val2);
        return Math.min(temp, val3);
    }
    private int max3(int val1, int val2, int val3) {
        int temp = Math.max(val1, val2);
        return Math.max(temp, val3);
    }
}
