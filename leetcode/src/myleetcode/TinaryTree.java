package myleetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TinaryTree {

	public static void main(String[] args) {
		TinaryTree tree = new TinaryTree();
		//add the example tree in the email
		tree.insert(5);
		tree.insert(4);
		tree.insert(9);
		tree.insert(5);
		tree.insert(7);
		tree.insert(2);
		tree.insert(2);
		//view the level order traverse
		tree.levelPrint();
		//delete root
		tree.delete(5);
		tree.levelPrint();
		
	}
	private TreeNode root = null;
	
	public TinaryTree () {
		super();
	}
	
	public void insert (int val) {
		if (this.root == null) {
			root = new TreeNode(val);
			return;
		}
		TreeNode newNode = new TreeNode(val);
		TreeNode scanner = root;
		//normal insert, similar to that in bst
		while (true) {
			if (scanner.val == val) {
				newNode.middle = scanner.middle;
				scanner.middle = newNode;
				break;
			} else if (scanner.val > val) {
				if (scanner.left == null) {
					scanner.left = newNode;
					break;
				} else {
					scanner = scanner.left;
				}
			} else {
				if (scanner.right == null) {
					scanner.right = newNode;
					break;
				} else {
					scanner = scanner.right;
				}
			}
		}
	}
	public boolean delete (int val) {
		//one parent dummy node to simplify the code
		TreeNode parent = new TreeNode(0);
		parent.left = root;
		root = parent;
		TreeNode scanner = root.left;
		while (scanner != null) {
			//find the node delete it, right subtree always add to 
			//the left / the right side of right most node of left subtree
			if (scanner.val == val) {
				if (scanner.left == null) {
					if (parent.left == scanner) {
						parent.left = scanner.right;
					} else {
						parent.right = scanner.right;
					}
				} else {
					TreeNode left = scanner.left;
					while (left.right != null) {
						left = left.right;
					}
					left.right = scanner.right;
					if (parent.left == scanner) {
						parent.left = left;
					} else {
						parent.right = left;
					}
				}
				root = root.left;
				return true;
			} else if (scanner.val > val) {
				parent = scanner;
				scanner = scanner.left;
			} else {
				parent = scanner;
				scanner = scanner.right;
			}
		}
		//no such node return false
		return false;
	}
	public void levelPrint () {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		if (root != null) que.offer(root);
		//normal level order traverse
		while (!que.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			int size = que.size();
			for (int i = 0; i < size; i++) {
				TreeNode curt = que.poll();
				sb.append(curt.val);
				if (curt.left != null) {
					que.offer(curt.left);
				}
				if (curt.middle != null) {
					que.offer(curt.middle);
				}
				if (curt.right != null) {
					que.offer(curt.right);
				}
			}
			System.out.println(sb);
		}
	}
	private class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode middle = null;
		public TreeNode (int val) {
			this.val = val;
		}
	}
	
}
