package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {

	public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0) return res;
        for (int i = 0; i < n; i++) {
            int base = 1 << i, size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(base + res.get(j));
            }
        }
        return res;
    }
}
