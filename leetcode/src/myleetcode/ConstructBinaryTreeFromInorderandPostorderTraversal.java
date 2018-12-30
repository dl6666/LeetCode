package myleetcode;


public class ConstructBinaryTreeFromInorderandPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int i = iStart;
        for (; i < iEnd; i++) {
            if (inorder[i] == postorder[pEnd]) {
                break;
            }
        }
        TreeNode left = helper(inorder, postorder, iStart, i - 1, pStart, pStart + i - iStart - 1);
        TreeNode right = helper(inorder, postorder, i + 1, iEnd, pStart + i - iStart, pEnd - 1);
        root.left = left;
        root.right = right;
        return root;
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
