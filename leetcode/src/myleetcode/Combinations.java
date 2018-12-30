package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, n, k, 1, new ArrayList<Integer>());
        return res;
    }
    public void helper(List<List<Integer>> res, int n, int k, int index, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            helper(res, n, k, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
