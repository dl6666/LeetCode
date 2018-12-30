package myleetcode;

public class ReverseNodesInK {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode dummyScan = dummy;
        dummy.next = head;
        while (head != null) {
            int i = 0;
            for (; i < k; i++) {
                if (head == null) {
                    break;
                }
                head = head.next;
            }
            if (i == k) {
                ListNode newNode = head, scan = dummyScan.next, tail = scan;
                while (scan != head) {
                    ListNode temp = scan.next;
                    scan.next = newNode;
                    newNode = scan;
                    scan = temp;
                }
                dummyScan.next = newNode;
                dummyScan = tail;
            }
        }
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
