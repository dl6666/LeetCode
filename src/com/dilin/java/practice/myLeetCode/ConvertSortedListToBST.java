package com.dilin.java.practice.myLeetCode;


public class ConvertSortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode mid = getMid(head);
        TreeNode root = new TreeNode(mid.next.val);
        root.right = sortedListToBST(mid.next.next);
        mid.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next; // critical to get the node before mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public class TreeNode{
		public int val = 0;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode (int val) {
			this.val = val;
		}
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
