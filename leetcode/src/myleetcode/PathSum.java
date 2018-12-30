package myleetcode;

import java.util.Stack;

public class PathSum {
//	public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null) {
//            if (root.val == sum) return true;
//            else return false;
//        }
//        if (root.left != null && hasPathSum (root.left, sum - root.val)) {
//            return true;
//        }
//        if (root.right != null && hasPathSum (root.right, sum - root.val)) {
//            return true;
//        }
//        return false;
//    }
	public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int cumu = 0;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                cumu += root.val;
                if (root.left == null && root.right == null && cumu == sum) {
                    return true;
                }
                root = root.left;
            } else if (stack.peek().right == pre) {
                pre = stack.pop();
                cumu -= pre.val;
            } else {
                pre = null;
                root = stack.peek().right;
            }
        }
        return false;
    }
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
