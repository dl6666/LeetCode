package com.dilin.java.practice.myLeetCode;


public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode curt = new ListNode(sum % 10);
            head.next = curt;
            head = curt;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ListNode curt = new ListNode(sum % 10);
            head.next = curt;
            head = curt;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode curt = new ListNode(sum % 10);
            head.next = curt;
            head = curt;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode curt = new ListNode(carry);
            head.next = curt;
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
