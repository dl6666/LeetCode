package myleetcode;

import java.util.ArrayList;

public class MaximumSubArrayII {

	public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE, len = nums.size(), sum = -1, res = Integer.MIN_VALUE;
        int[] lMax = new int[len];
        for (int i = 0; i < len; i++) {
            int curt = nums.get(i);
            sum = sum > 0 ? sum + curt : curt;
            max = Math.max(max, sum);
            lMax[i] = max;
        }
        sum = -1;
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i > 0; i--) {
            int curt = nums.get(i);
            sum = sum > 0 ? sum + curt : curt;
            max = Math.max(max, sum);
            res = Math.max(res, max + lMax[i - 1]);
        }
        return res;
    }
}
