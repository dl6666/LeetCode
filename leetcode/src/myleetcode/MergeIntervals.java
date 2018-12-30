package myleetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size == 1) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Comparator<Interval> comp = new Comparator<Interval>() {
            public int compare (Interval it1, Interval it2) {
                return it1.start - it2.start;    
            }
        };
        Collections.sort(intervals, comp);
        Iterator<Interval> it = intervals.iterator();
        Interval scan = null;
        while (it.hasNext()) {
            if (scan == null) {
                scan = it.next();
            } else {
                Interval curt = it.next();
                if (curt.start <= scan.end) {
                    scan.end = Math.max(scan.end, curt.end);
                } else {
                    res.add(scan);
                    scan = curt;
                }
            }
        }
        if (scan != null) {
            res.add(scan);
        }
        return res;
	}
	public class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
}
