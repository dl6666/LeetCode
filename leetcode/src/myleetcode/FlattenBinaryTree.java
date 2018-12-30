package myleetcode;


public class FlattenBinaryTree {

	public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode leftBiggest = getBig(root.left);
        if (leftBiggest != null) {
            leftBiggest.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    public TreeNode getBig(TreeNode root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
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
