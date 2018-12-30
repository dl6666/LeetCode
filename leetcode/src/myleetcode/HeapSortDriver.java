package myleetcode;

public class HeapSortDriver {

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(10);
		int[] input = {2,4,5,71,2,52,2,3,4};
		heap.createHeap(input);
		int[] res = new int[input.length];
		for (int i = 0 ;i < res.length; i++) {
			res[i] = heap.getMax();
		}
		for (int i : res) {
			System.out.print(i);
			System.out.print('.');

		}
	}
}
