package myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int[] num, boolean[] used, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            int pre = Integer.MAX_VALUE;
            for (int i = 0; i < num.length; i++) {
                if (!used[i] && num[i] != pre) {
                    temp.add(num[i]);
                    used[i] = true;
                    helper(num, used, temp, res);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                    pre = num[i];
                }
            }
        }
    } 
}
