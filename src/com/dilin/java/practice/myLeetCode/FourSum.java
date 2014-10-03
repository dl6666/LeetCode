package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return res;
        int len = num.length;
        Arrays.sort(num);
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int newTar = target - num[i] - num[j];
                int start = j + 1;
                int end = len - 1;
                while (start < end) {
                    if (start != j + 1 && num[start] == num[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end != len -1 && num[end] == num[end + 1]) {
                        end--;
                        continue;
                    }
                    int sum = num[start] + num[end];
                    if (sum == newTar) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        res.add(temp);
                        start++;
                        end--;
                    } else if (sum < newTar) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }

}
