package myleetcode;


public class ConvertSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length - 1);
    }
    public TreeNode helper(int[] num, int start, int end) {
        if (end < start) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode left = helper(num, start, mid - 1);
        TreeNode right = helper(num, mid + 1, end);
        root.left = left;
        root.right = right;
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
