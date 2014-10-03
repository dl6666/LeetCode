package com.dilin.java.practice.myLeetCode;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length == 0) return Integer.MAX_VALUE;
       int sum = Integer.MAX_VALUE, len = num.length, closest = Integer.MAX_VALUE / 2;
       Arrays.sort(num);
       for (int i = 0; i < len - 2; i++) {
           int start = i + 1;
           int end = len - 1;
           while(start < end) {
               if (start != i + 1 && num[start] == num[start - 1]) {
                   start++;
                   continue;
               }
               if (end != len - 1 && num[end] == num[end + 1]) {
                   end--;
                   continue;
               }
               sum = num[i] + num[start] + num[end];
               closest = Math.abs(target - closest) > Math.abs(target - sum) ? sum : closest;
               if (sum == target) {
                   return target;
               } else if (sum > target) {
                   end--;
               } else {
                   start++;
               }
           }
       }
       return closest;
    }
}
