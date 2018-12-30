package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        boolean conti = true;
        Queue<String> que = new LinkedList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        if (dict.contains(end)) {
            que.offer(end);
        }
        while (conti && !que.isEmpty()) {
            Iterator<String> it = que.iterator();
            while (it.hasNext()) {
                dict.remove(it.next());
            }
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String curt = que.poll();
                char[] curtArray = curt.toCharArray();
                int len = curt.length();
                for (int j = 0; j < len; j++) {
                    char save = curtArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curtArray[j] = c;
                        String changed = new String(curtArray);
                        if (dict.contains(changed)) {
                            if (changed.equals(start)) conti = false;
                            if (map.containsKey(changed)) {
                                map.get(changed).add(curt);
                            } else {
                                List<String> temp = new ArrayList<String>();
                                temp.add(curt);
                                map.put(changed, temp);
                                que.offer(changed);//mistake
                            }
                        }
                    }
                    curtArray[j] = save;
                }
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        temp.add(start);
        helper(res, map, start, end, temp);
        return res;
    }
    private void helper(List<List<String>> res, Map<String, List<String>> map, String start, String end, List<String> temp) {
        if (start.equals(end)) {
            res.add(new ArrayList<String>(temp));
        } else {
            if (map.containsKey(start)) {
                List<String> neighbors = map.get(start);
                for (String s : neighbors) {
                    temp.add(s);
                    helper(res, map, s, end, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
