package com.dilin.java.practice.imp.problems;

public class RebuildAlphDriver {

	public static void main(String[] args) {
		RebuildAlph r = new RebuildAlph();
		r.insertConstraint("abc");
		r.insertConstraint("cd");
		System.out.println(r.getTSort());
	}
}
