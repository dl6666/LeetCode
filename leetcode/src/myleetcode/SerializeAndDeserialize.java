package com.dilin.java.practice.imp.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.dilin.java.practice.myLeetCode.TreeNode;

public class SerializeAndDeserialize {

	public TreeNode constructTree (int[] vals) {
		int len = vals.length;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		for (int i = 0; i < len; i++) {
			TreeNode curt = new TreeNode(vals[i]);
			while (!stack.isEmpty() && stack.peek().val < curt.val) {
				TreeNode small = stack.pop();
				int left = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().val;
				if (left > curt.val) {
					curt.left = small;
				} else {
					stack.peek().right = small;
				}
			}
			stack.push(curt);
		}
		TreeNode root = null;
		while (!stack.isEmpty()) {
			root = stack.pop();
			if (!stack.isEmpty()) {
				stack.peek().right = root;
			}
		}
		return root;
	}
	public void print(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < size; i++) {
				TreeNode curt = q.poll();
				sb.append(curt.val);
				if (curt.left != null) {
					q.offer(curt.left);
				}
				if (curt.right != null) {
					q.offer(curt.right);
				}
			}
			System.out.println(sb.toString());
		}
	}
	public TreeNode deserialize(String s) {
		StringIter it = new StringIter(s);
		return deHelper(it);
	}
	private TreeNode deHelper(StringIter it) {
		if (it.hasNext()) {
			char curt = it.getNext();
			if (curt == '#') {
				return null;
			} else {
				TreeNode root = new TreeNode(curt - '0');
				root.left = deHelper(it);
				root.right = deHelper(it);
				return root;
			}
		}
		return null;
	}
	public String serialize(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		StringBuffer  sb = new StringBuffer();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				sb.append(root.val);
				stack.push(root);
				root = root.left;
			} else {
				sb.append('#');
				root = stack.pop();
				root = root.right;
			}
		}
		return sb.toString();
	}
	private class StringIter {
		private int i;
		private String s;
		public StringIter(String s) {
			this.s  = s;
			i = 0;
		}
		public boolean hasNext() {
			return i != s.length();
		}
		public char getNext() {
			if (i == s.length()) return '$';
			return s.charAt(i++);
		}
	}
}
