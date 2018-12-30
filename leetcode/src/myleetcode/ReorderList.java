package myleetcode;


public class ReorderList {

	public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = getMid(head);
        ListNode right = rotateList(mid.next);
        mid.next = null;
        merge (head, right);
    }
    private ListNode getMid(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode rotateList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode save = dummy;
        while (list1 != null && list2 != null) {
            dummy.next = list1;
            list1 = list1.next;
            dummy = dummy.next;
            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;
        }
        if (list1 != null) {
            dummy.next = list1;
        }
        if (list2 != null) {
            dummy.next = list2;
        }
        return save.next;
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
