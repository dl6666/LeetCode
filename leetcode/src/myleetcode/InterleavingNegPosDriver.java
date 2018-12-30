package myleetcode;

public class InterleavingNegPosDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingNegPos it = new InterleavingNegPos();
		int[] input = {-2,1,1,1,4,-3,-5,2};
		it.reorder(input);
		for (int i : input) {
			System.out.print(i);

		}
	}

}
