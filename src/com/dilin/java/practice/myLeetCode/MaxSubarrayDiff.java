package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;

public class MaxSubarrayDiff {

	public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() < 2) return 0;
        int len = nums.size(), max = nums.get(0), min = nums.get(0);
        int[] maxA = new int[len], minA = new int[len];
        maxA[0] = minA[0] = nums.get(0);
        for (int i = 1; i < len; i++) {
            int curt = nums.get(i);
            max = max > 0 ? max + curt : curt;
            min = min < 0 ? min + curt : curt;
            maxA[i] = Math.max(max, maxA[i - 1]);
            minA[i] = Math.min(min, minA[i - 1]);
        }
        int diff = 0, maxR = Integer.MIN_VALUE, minR = Integer.MAX_VALUE;
        max = -1;
        min = 1;
        for (int i = len - 1; i > 0; i--) {
            int curt = nums.get(i);
            max = max > 0 ? max + curt : curt;
            min = min < 0 ? min + curt : curt;
            minR = Math.min(minR, min);
            maxR = Math.max(maxR, max);
            int lr = Math.max(Math.abs(maxA[i - 1] - minR), Math.abs(minA[i - 1] - maxR));
            diff = Math.max(diff, lr);
        }
        return diff;
    }
}
