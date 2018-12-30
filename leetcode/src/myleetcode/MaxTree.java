package com.dilin.java.practice.imp.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxTree {
	public static void main (String[] args) {
		MaxTree mt = new MaxTree();
		MaxTree.TreeNode root = mt.constructMaxTree(new int[] {1,3,4,2,1,5,7,3,1,2});
		Queue<MaxTree.TreeNode> q = new LinkedList<MaxTree.TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < size; i++) {
				MaxTree.TreeNode curt = q.poll();
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
	public TreeNode constructMaxTree (int[] vals) {
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
	public class TreeNode{
		public int val = 0;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode (int val) {
			this.val = val;
		}
	}
}
