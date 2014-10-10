package com.dilin.java.practice.imp.problems;

public class StringToLong {
	public static void main(String[] args) {
		String[] inputs = new String[]{
				"-00009888",
				"9873",
				"-00983",
				"-00000009358749259342159215792175483920517",
				"9223372036854775807",
				"00099fd"};
		long[] expected = new long[] {
				-9888,
				9873,
				-983,
				Long.MIN_VALUE,
				Long.MAX_VALUE,
				0
		};
		for (int i = 0; i < inputs.length; i++) {
			long res = stringToLong(inputs[i]);
			System.out.println();
			if (res == expected[i]) {
				System.out.println(inputs[i] + " --> " + res +" : test case " + i + " passed");
			} else {
				System.out.println("test case " + i + " failed");
			}
		}
	}
	public static long stringToLong (String s) {
		long res = 0;
		if (s == null || s.length() == 0) return res;
		int len = s.length();
		boolean pos = true;
		//get rid of the possible sign
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			if (s.charAt(0) == '-') pos = false;
			s = s.substring(1);
			len = s.length();
		}
		//get rid of the possible 0 in front
		int i = 0;
		while (i < len && s.charAt(i) == '0') i++;
		s = i == len ? "" : s.substring(i);
		len = s.length();
		//scan from the end to get the res
		for (i = 0; i < len; i++) {
			char curt = s.charAt(i);
			if (curt > '9' || curt < '0') return 0;
			int curtNum = curt - '0';
			if (pos) {
				if (res > Long.MAX_VALUE / 10 || (res == Long.MAX_VALUE / 10 && curtNum >= Long.MAX_VALUE % (Long.MAX_VALUE / 10)) ){
					return Long.MAX_VALUE;
				}
			} else {
				if (res > Long.MAX_VALUE / 10 || (res == Long.MAX_VALUE / 10 && curtNum >= Long.MAX_VALUE % (Long.MAX_VALUE / 10) + 1) ){
					return Long.MIN_VALUE;
				}
			}
			res *= 10;
			res += curtNum;
		}
		return pos ? res : -res;
	}
}
