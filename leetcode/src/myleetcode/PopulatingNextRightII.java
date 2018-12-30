package myleetcode;


public class PopulatingNextRightII {

	public void connect(TreeLinkNode root) {
        TreeLinkNode pre = root, nextDummy = new TreeLinkNode(0), next = nextDummy;
        while(pre != null) {
            while (pre != null) {
                if (pre.left != null) {
                    next.next = pre.left;
                    next = next.next;
                }
                if (pre.right != null) {
                    next.next = pre.right;
                    next = next.next;
                }
                pre = pre.next;
            }
            pre = nextDummy.next;
            nextDummy.next = null;
            next = nextDummy;
        }
    }
	class TreeLinkNode {
	      TreeLinkNode left;
	      TreeLinkNode right;
	      TreeLinkNode next;
	      int val;
	      TreeLinkNode(int val) {
	    	  this.val = val;
	      }
	}
}
