package myleetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) return null;
        int size = lists.size();
        ListNode dummy = new ListNode(0),save = dummy;
    	Comparator<ListNode> comp = new Comparator<ListNode>(){
    	    public int compare(ListNode l1, ListNode l2) {
    	        return l1.val - l2.val;
    	    }
    	};
    	PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(size, comp);
    	Iterator<ListNode> it = lists.iterator();
    	while (it.hasNext()) {
    	    ListNode curt = it.next();
    	    if (curt != null) {
    	        que.offer(curt);
    	    }
    	}
    	while (!que.isEmpty()) {
    	    ListNode curt = que.poll();
    	    dummy.next = curt;
    	    dummy = dummy.next;
    	    if (curt.next != null) {
    	        que.offer(curt.next);
    	    }
    	}
    	return save.next;
    }
}
