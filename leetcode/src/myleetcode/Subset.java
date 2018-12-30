package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] S) {
        int len = S.length;
        int total = 1 << len;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        for (int i = 0; i < total; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(S[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
