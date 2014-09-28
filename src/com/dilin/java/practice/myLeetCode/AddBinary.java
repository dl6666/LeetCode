package com.dilin.java.practice.myLeetCode;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int endA = a.length() - 1, endB = b.length() - 1, index = 0, carry = 0;
        int[] res = new int[Math.max(endA, endB) + 2];
        while (endA >= 0 && endB >= 0) {
            int ai = a.charAt(endA) - '0', bi = b.charAt(endB) - '0';
            int curt = ai + bi + carry;
            res[index] = curt % 2;
            carry = curt / 2;
            endA--;
            endB--;
            index++;
        }
        while (endA >= 0) {
            int ai = a.charAt(endA) - '0';
            int curt = carry + ai;
            res[index++] = curt % 2;
            carry = curt / 2;
            endA--;
        }
        while (endB >= 0) {
            int bi = b.charAt(endB) - '0';
            int curt = carry + bi;
            res[index++] = curt % 2;
            carry = curt / 2;
            endB--;
        }
        res[index] = carry;
        index = res.length - 1;
        while (index >= 0 && res[index] == 0) index--;
        if (index == -1) return "0";  // boundary case
        StringBuffer sb = new StringBuffer();
        while (index >= 0) {
            sb.append((char)(res[index--] + '0'));
        }
        return sb.toString();
    }
}
