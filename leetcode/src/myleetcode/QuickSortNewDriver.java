package com.dilin.java.practice.imp.problems;

public class QuickSortNewDriver {

	public static void main (String[] args) {
		int[] input = {5,0,2,0,9,1,1,1,11,3,5,32};
		QuickSortNew q = new QuickSortNew();
		q.quickSort(input);
		for (int i : input) {
			System.out.print(i);
			System.out.print('-');

		}
	}
}
