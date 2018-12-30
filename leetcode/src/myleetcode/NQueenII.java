package myleetcode;

public class NQueenII {

	public int totalNQueens(int n) {
	    int[] q = new int[n];
	    return helper(q, n, 0);
	}
	private int helper (int[] q, int n, int index) {
	    if (index == n) return 1;
	    int c = 0;
	    for(int i = 0; i < n; i++) {
	        q[index] = i;
	        if (isValid(q, index, n)) {
	            c += helper(q, n, index + 1);
	        }
	    }
	    return c;
	}
	private boolean isValid (int[] q, int index, int n) {
	    for (int i = 0; i < index; i++) {
	        if (q[i] == q[index]) return false;
	        if (Math.abs(i - index) == Math.abs(q[i] - q[index])) return false;
	    }
	    return true;
	    
	}
}
