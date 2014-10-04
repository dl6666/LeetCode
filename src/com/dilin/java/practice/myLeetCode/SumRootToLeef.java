package com.dilin.java.practice.myLeetCode;


public class SumRootToLeef {

	public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper (TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val + sum * 10;
        }
        int s = 0;
        if (root.left != null) {
            s += helper (root.left, sum * 10 + root.val);
        }
        if (root.right != null) {
            s += helper (root.right, sum * 10 + root.val);
        }
        return s;
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
