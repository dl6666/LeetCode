package myleetcode;

import java.util.Stack;

public class FlattenBST {

	public static void main (String[] args) {
		TreeNode temp = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode leftleft = new TreeNode(3);
		TreeNode leftright = new TreeNode(4);
		left.left = leftleft;
		left.right = leftright;
		TreeNode right = new TreeNode(6);
		temp.left = left;
		temp.right = right;
		TreeNode root = temp;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.println(root.val);
				root = root.right;
			}
		}
		flatten(temp);
		root = leftleft;
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}
	public static void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                TreeNode temp = root;
                stack.push(root);
                root = root.left;
                temp.left = null;
            } else {
                root = stack.pop();
                dummy.right = root;
                dummy = dummy.right;
                root = root.right;
            }
        }
    }
}
