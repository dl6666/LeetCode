package myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {

	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        helper(res, num, 0, new ArrayList<Integer>());
        return res;
    }
    private void helper (List<List<Integer>> res, int[] num, int index, List<Integer> temp) {
        int len = num.length;
        res.add(new ArrayList<Integer>(temp));
        for (int i = index; i < len; i++) {
            if (i == index || num[i] != num[i - 1]) {
                temp.add(num[i]);
                helper(res, num, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
