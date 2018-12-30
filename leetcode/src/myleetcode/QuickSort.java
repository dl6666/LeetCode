package myleetcode;

import java.util.Random;

public class QuickSort {
	private int partition (int[] num, int start, int end) {
		Random rand = new Random();
		int index = start + rand.nextInt(end - start + 1);
		int piv = num[index];
		while (start <= end) {
			while (num[start] < piv) {
				start++;
			}
			while (num[end] > piv) {
				end--;
			}
			if (start <= end) {
				swap(num, start, end);
				start++;
				end--;
			}
		}
		return start;
	}
	private void swap (int[] num, int start, int end) {
		int temp = num[start];
		num[start] = num[end];
		num[end] = temp;
	}
	public void quickSort (int[] num) {
		if (num == null || num.length < 2) return;
		quickSortRec(num, 0, num.length - 1);
	}
	private void quickSortRec (int[] num, int start, int end) {
		if (start >= end) return;
		int piv = partition (num, start, end);
		quickSortRec (num, start, piv - 1);
		quickSortRec (num, piv, end);
	}
}
