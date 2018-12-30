package myleetcode;

import java.util.ArrayList;

public class MaximumSubArrayIII {

	public int maxSubArray(ArrayList<Integer> nums, int k) {
        // f[i][j] max sum  of first i nums of j pieces 
        // f[i][j] = max{f[l =  j - 2 ~ i - 1][j - 1] + m[l + 1][i]}
        // m[i][j] max sum between i and j
        int len = nums.size(), sum = -1, max = Integer.MIN_VALUE; 
        if (k > len) return 0;
        int[][] m = new int[len][len];
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            m[i][i] = nums.get(i);
            sum = m[i][i];
            for (int j = i + 1; j < len; j++) {
                int curt = nums.get(j);
                sum = sum > 0 ? sum + curt : curt;
                m[i][j] = Math.max(m[i][j - 1], sum);
            }
        }
        for (int i = 0; i < len; i++) {
            f[i] = m[0][i];
        }
        for (int j = 2; j <= k; j++) {
            for (int i = len - 1; i >= j - 1; i--) {//should search from the back
                max = Integer.MIN_VALUE;
                for (int l = j - 2; l < i; l++) {
                    max = Math.max(max, f[l] + m[l + 1][i]);
                }
                f[i] = max;
            }
        }
        return f[len - 1];
    }
}
