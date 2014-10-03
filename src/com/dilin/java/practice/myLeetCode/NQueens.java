package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<String[]> solveNQueens(int n) {
        int[] sol = new int[n];
        List<String[]> res = new ArrayList<String[]>();
        if (n == 0) return res;
        helper(res, sol, 0);
        return res;
    }
    private void helper (List<String[]> res, int[] sol, int row) {
        int len = sol.length;
        if (row == len) {
            res.add(print(sol));
            return;
        }
        for (int i = 0; i < len; i++) {
            sol[row] = i;
            if (isValid(sol, row)) {
                helper(res, sol, row + 1);
            }
        }
    }
    private boolean isValid(int[] sol, int row) {
        int col = sol[row];
        for (int i = 0; i < row; i++) {
            if (sol[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(sol[i] - sol[row])) {
                return false;
            }
        }
        return true;
    }
    private String[] print (int[] sol) {
        int len = sol.length;
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < sol[i]; j++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int j = sol[i] + 1; j < len; j++) {
                sb.append('.');
            }
            res[i] = sb.toString();
        }
        return res;
    }
}
