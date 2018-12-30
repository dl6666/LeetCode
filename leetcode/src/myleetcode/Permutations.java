package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, num, new boolean[num.length], new ArrayList<Integer>());
        return res;
    }
    public void helper(List<List<Integer>> res, int[] num, boolean[] visited, List<Integer> temp) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                temp.add(num[i]);
                visited[i] = true;
                helper(res, num, visited, temp);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
