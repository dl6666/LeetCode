package com.dilin.java.practice.imp.problems;

public class UnsortedPairsDriver {

	public static void main (String[] args) {
		UnsortedPairs up = new UnsortedPairs();
		int[] input = {3,4,2,1};
		int res = up.countPairs(input, 0, input.length - 1);
		System.out.println(res);
	}
}
