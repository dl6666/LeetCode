package com.dilin.java.practice.myLeetCode;


public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode curt = head;
            head = head.next;
            int val = curt.val;
            ListNode scan = dummy;
            while (scan.next != null && scan.next.val <= val) {
                scan = scan.next;
            }
            curt.next = scan.next;
            scan.next = curt;
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
