package myleetcode;

public class JumpGame {

	public boolean canJump(int[] A) {
        int reach = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + A[i]);
        }
        return true;
    }
}
