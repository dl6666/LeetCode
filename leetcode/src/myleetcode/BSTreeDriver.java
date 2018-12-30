package com.dilin.java.practice.imp.problems;

public class BSTreeDriver {
	public static void main (String[] args) {
		BSTree bt = new BSTree();
		bt.add(0);
		bt.add(1);
		bt.add(5);
		bt.add(3);
		bt.print();
		bt.delete(1);
		bt.print();
	}
}
