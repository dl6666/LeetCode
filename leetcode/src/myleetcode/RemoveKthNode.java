package myleetcode;


public class RemoveKthNode {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            pre = pre.next;
            head = head.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
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
