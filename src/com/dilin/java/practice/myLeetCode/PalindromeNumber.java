package com.dilin.java.practice.myLeetCode;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long start = 1, end = 10;
        while (x / start != 0) {
            start *= 10;
        }
        while (start > end) {
            if ((x % start) / (start / 10) != (x % end) / (end / 10)) return false;
            start /= 10;
            end *= 10;
        }
        return true;
    }
}
