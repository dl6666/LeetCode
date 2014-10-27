package com.dilin.java.practice.imp.problems;

public class BSTSpan {

	public Node span(Node root, int start ,int end) {
		if (root == null) return null;
		if (root.val < start) {
			return span(root.right, start, end);
		} else if (root.val > end) {
			return span(root.left, start, end);
		} else {
			Node newRoot = new Node(root.val);
			newRoot.left = span(root.left, start, end);
			newRoot.right = span(root.right, start, end);
			return newRoot;
		}
	}
	private class Node {
		public Node left;
		public Node right;
		public int val;
		public Node(int val) {
			this.val = val;
		}
	}
}
