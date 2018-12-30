package myleetcode;

public class Sqrt {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode save = dummy;
        dummy.next = head;
        for (int i = 1; i < m; i++) {
            dummy = dummy.next;
        }
        dummy.next = reverseN (dummy.next, n - m);
        return save.next;
    }
    private ListNode reverseN (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i <= n; i++) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        tail.next = head;
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
