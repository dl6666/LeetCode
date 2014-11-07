package com.dilin.java.practice.myLeetCode;

public class DoubleNumber {
	public static void main(String[] args) {
		System.out.println(doubleNumber(new int[] {4,4,4,4,1,1,1,3,1,3}));
	}
	public enum Level {
	    HIGH,
	    MEDIUM,
	    LOW
	}
	public static int doubleNumber(int[] nums) {
		Level level = Level.HIGH;
		if (level == Level.HIGH) {
			
		}
		int one = 0, two = 0, three = 0, four = 0;
		for (int i = 0; i < nums.length; i++) {
			int curt = nums[i];
			four  = three & curt;
			curt &= ~four;
			three &= ~four;
			int temp = two & curt;
			three |= temp;
			curt &= ~temp;
			two &= ~temp;
			temp = one & curt;
			two |= temp;
			curt &= ~temp;
			one &= ~temp;
			one = curt;
		}
		return two;
	}
}
