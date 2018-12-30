package myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }
    private void helper (int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
        } else if (target > 0) {
            int len = candidates.length;
            int pre = -1;
            for (int i = index; i < len; i++) {
                if(candidates[i] != pre) {
                    temp.add(candidates[i]);
                    helper(candidates, res, temp, target - candidates[i], i);
                    temp.remove(temp.size() - 1);
                    pre = candidates[i];
                }
            }
        } else {
            return;
        }
    }

}
