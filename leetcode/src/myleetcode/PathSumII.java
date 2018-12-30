package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper (TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (sum == root.val && root.left == null && root.right == null) {
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
        } else {
            if (root.left != null) {
                temp.add(root.val);
                helper(root.left, sum - root.val, temp, res);
                temp.remove(temp.size() - 1);
            }
            if (root.right != null) {
                temp.add(root.val);
                helper(root.right, sum - root.val, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
