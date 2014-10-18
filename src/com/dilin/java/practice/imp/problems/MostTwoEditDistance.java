package com.dilin.java.practice.imp.problems;

public class MostTwoEditDistance {

	public boolean fewerThanDis(String s1, int i1, String s2, int i2, int dis) {
		if (dis > 2) return false;
		if(i1 == s1.length() && i2 == s2.length()) return true;
		if(i1 == s1.length() || i2 == s2.length()) return false;
		if(s1.charAt(i1) == s2.charAt(i2)) {
			return fewerThanDis(s1,i1 + 1, s2, i2 + 1, dis);
		} else {
			return fewerThanDis(s1,i1 + 1, s2, i2, dis + 1) || fewerThanDis(s1, i1, s2, i2 + 1, dis + 1) || fewerThanDis(s1, i1 + 1, s2, i2 + 1, dis + 1);
		}
	}
}
