package myleetcode;

public class QuickSortDriver {

	public static void main (String[] args) {
		int[] input = {5,0,2,0,9,1,1,1,11,3,5,32};
		QuickSort q = new QuickSort();
		q.quickSort(input);
		for (int i : input) {
			System.out.print(i);
			System.out.print('-');

		}
	}
}
