package myleetcode;

import java.util.Stack;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack<TreeNode>(), sq = new Stack<TreeNode>();
        while (p != null || !sp.isEmpty()){ 
            if (p == null) {
                p = sp.pop();
                if (q != null) {
                    return false;
                } else {
                    q = sq.pop();
                    if (p.val != q.val) {
                        return false;
                    }
                    q = q.right;
                }
                p = p.right;
            } else {
                sp.push(p);
                if (q == null) {
                    return false;
                } else {
                    sq.push(q);
                    q = q.left;
                }
                p = p.left;
            }
        }
        return q == null && sq.isEmpty();
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
