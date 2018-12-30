package myleetcode;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int end = 1, len = A.length;
        for (int i = 1; i < len; i++) {
            if (A[i] != A[i - 1]) {
                A[end] = A[i];
                end++;
            }
        }
        return end;
    }
}
