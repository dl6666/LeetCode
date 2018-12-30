package com.dilin.java.practice.myLeetCode;

public class IntegerToRoman {

	public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] r = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;
        while (num > 0) {
            while (num < n[i]) i++;//critical, have present number bigger or equal to n[i]
            num -= n[i];
            sb.append(r[i]);
        }
        return sb.toString();
    }
}
