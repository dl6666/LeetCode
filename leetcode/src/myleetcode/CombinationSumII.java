package myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, num, 0, target, new ArrayList<Integer>());
        return res;
    }
    private void helper (List<List<Integer>> res, int[] num, int start, int target, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i < num.length && target >= num[i]; i++) {
                if (i == start || num[i] != num[i - 1]) {
                    temp.add(num[i]);
                    helper (res, num, i + 1, target - num[i], temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
