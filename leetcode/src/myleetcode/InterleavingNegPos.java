package myleetcode;

public class InterleavingNegPos {

	public int[] reorder(int[] num) {
		if (num.length < 2) return num;
		int len = num.length;
		for (int i = 1; i < len - 1; i++) {
			int index = i + 1;
			if (num[index] * num[i] < 0) {
				continue;
			}
			while (index < len && num[index] * num[i] > 0) {
				index++;
			}
			if (index < len) {
				swap (num, i + 1, index);
				i++;
			} else {
				i = len;
			}
		}
		return num;
	}
	private void swap(int[] num, int i, int j) {
		if (i == j) return;
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
