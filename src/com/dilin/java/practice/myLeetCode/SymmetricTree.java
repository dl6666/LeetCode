package com.dilin.java.practice.myLeetCode;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val){
            return false;
        } else {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
    private class TreeNode {
		public int val = 0;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode (int val) {
			this.val = val;
		}
	}
}
