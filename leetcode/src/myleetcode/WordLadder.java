package myleetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        int count = 1;
        if (dict.contains(start)) {
            if (start.equals(end)) return count;
            q.offer(start);
            dict.remove(start);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int j = 0; j < size; j++) {
                char[] curt = q.poll().toCharArray();
                int len = curt.length;
                for (int i = 0; i < len; i++) {
                    char save = curt[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curt[i] = c;
                        String changed = String.valueOf(curt);
                        if (dict.contains(changed)) {
                            if (changed.equals(end)){
                                return count;
                            }
                            dict.remove(changed);
                            q.offer(changed);
                        }
                    }
                    curt[i] = save;
                }
            }
        }
        
        return 0;
    }

}
