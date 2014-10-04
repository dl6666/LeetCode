package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleI {

	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> curt = new ArrayList<Integer>();
            curt.add(1);
            if (i > 1) {
                List<Integer> pre = result.get(result.size() - 1);
                int size = pre.size();
                for (int j = 1; j < size; j++) {
                    curt.add(pre.get(j - 1) + pre.get(j));
                }
                curt.add(1);
            }
            result.add(curt);
        }
        return result;
    }
}
