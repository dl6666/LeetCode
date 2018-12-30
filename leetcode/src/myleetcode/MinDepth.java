package myleetcode;


public class MinDepth {

	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) { //meaning leef
            return 1;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;//critical
        if (root.left != null) {
            left = minDepth(root.left);
        }
        if (root.right != null) {
            right = minDepth(root.right);
        }
        return 1 + Math.min(left, right);
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
