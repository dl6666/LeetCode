package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>(), curt = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            curt = new ArrayList<Integer>();//critical
            curt.add(1);
            if (i > 0) {
                int size = pre.size();
                for (int j = 1; j < size; j++) {
                    curt.add(pre.get(j - 1) + pre.get(j));
                }
                curt.add(1);
            }
            pre = curt;
        }
        return curt;
    }
}
