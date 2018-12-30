package myleetcode;


public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
	public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        	val = x;
    	    next = null;
       }
    }
}

