package myleetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree {
	public TreeNode root = null;
	public BSTree (TreeNode root) {
		this.root = root;
	}
	public BSTree () {
		super();
	}
	public void print() {
		if (root == null) return;
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
	public void add(int val) {
		TreeNode newNode = new TreeNode(val);
		if (root == null) {
			root = newNode;
		} else {
			int newVal = newNode.val;
			TreeNode scan = root;
			while (scan != null) {
				int curtVal = scan.val;
				if (curtVal >= newVal) {
					if (scan.left == null) {
						scan.left = newNode;
						scan = null;
					} else {
						scan = scan.left;
					}
				} else if (curtVal < newVal){
					if (scan.right == null) {
						scan.right = newNode;
						scan = null;
					} else {
						scan = scan.right;
					}
				}
			}
		}
	}
	public TreeNode find (int val) {
		TreeNode scan = root;
		while (scan != null) {
			int curt = scan.val;
			if (curt == val) {
				return scan;
			} else if (curt < val) {
				scan = scan.right;
			} else {
				scan = scan.left;
			}
		}
		return null;
	}
	public boolean delete(int val) {
		TreeNode parent = new TreeNode(0);
		parent.left = root;
		TreeNode scan = root;
		while (scan != null) {
			int curt = scan.val;
			if (curt == val) {
				break;
			} else if (curt > val){
				parent = scan;
				scan = scan.left;
			} else {
				parent = scan;
				scan = scan.right;
			}
		}
		if (scan == null) return false;
		if (scan.left == null) {
			if (parent.left == scan) {
				parent.left = scan.right;
			} else {
				parent.right = scan.right;
			}
		} else if (scan.right != null) {
			if (parent.left == scan) {
				parent.left = scan.left;
			} else {
				parent.right = scan.left;
			}
			TreeNode left = scan.left;
			while (left.right != null) {
				left = left.right;
			}
			left.right = scan.right;
		}
		return true;
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
