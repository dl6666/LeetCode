package myleetcode;

public class ValidNumber {
	public enum Input {
		INVALID(-1),
		DOT(0),
		SPACE(1),
		DIGIT(2),
		SIGN(3),
		E(4);
		public int val;
		private Input (int input) {
			this.val = input;
		}
	};
	public boolean isNumber(String s) {
		int[][] trans  = new int[][] {
		        { -1, -1, -1, -1},
				{ 4, 1, 3, 2,-1},
				{ 4,-1, 3,-1,-1},
				{ 5, 6, 3,-1, 7},
				{-1,-1, 5,-1,-1},
				{-1, 6, 5,-1, 7},
				{-1, 6,-1,-1,-1},
				{-1,-1, 8, 9,-1},
				{-1, 6, 8,-1,-1},
				{-1,-1, 8,-1,-1}
		};
		int len = s.length();
		int state = 1;
		for (int i = 0; i < len; i++) {
		    Input input = Input.INVALID;
			char curt = s.charAt(i);
			if (curt == '.') {
				input = Input.DOT;
			} else if (curt == ' ') {
				input = Input.SPACE;
			} else if (curt == '+' || curt == '-') {
				input = Input.SIGN;
			} else if (curt == 'e' || curt == 'E') {
				input = Input.E;
			} else if (curt >= '0' && curt <= '9') {
				input = Input.DIGIT;
			}
			if (input.val == -1) return false;
			state = trans[state][input.val];
			if (state == -1) return false;
		}
		return state == 3 || state == 5 || state == 6 || state == 8;
	}
}
