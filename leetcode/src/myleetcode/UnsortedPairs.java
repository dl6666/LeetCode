package myleetcode;

public class UnsortedPairs {

	public int countPairs(int[] input, int start, int end) {
		if (start == end) return 0;
		int mid = start + (end - start) / 2;
		int count = 0;
		int left = countPairs(input, start, mid);
		int right = countPairs(input, mid + 1, end);
		int i = mid, j = end - mid - 1, index = end;
		int[] temp = new int[end - mid];
		for (int k = mid + 1; k <= end; k++) {
			temp[k - mid - 1] = input[k];
		}
		while (i >= start && j >= 0) {
			if (input[i] <= temp[j]) {
				input[index] = temp[j];
				count += mid - i;
				j--;
			} else {
				input[index] = input[i];
				i--;
			}
			index--;
		}
		while (i >= start) {
			input[index] = input[i];
			i--;
			index--;
		}
		while (j >= 0) {
			input[index] = temp[j];
			j--;
			index--;
			count += mid - start + 1;
		}
		return count + left + right;
	}
}
