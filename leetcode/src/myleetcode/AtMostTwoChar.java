package myleetcode;


public class AtMostTwoChar {

	public static void main (String[] args) {
		System.out.println(longest("fjdlksajjfjjjjjjddddkkkkief"));
	}
	public static int longest(String s) {
		char first = ' ', second = ' ';
		int firstS = 0, firstE = 0, secondS = 0, secondE = 0, len = s.length(), max = 0;
		for (int i = 0; i < len; i++) {
			char curt = s.charAt(i);
			if (curt == first) {
				firstE = i;
			} else if (curt == second) {
				secondE = i;
			} else {
				first = second;
				second = curt;
				firstS = secondS;
				firstE = secondE;
				secondS = i;
				secondE = i;
			}
			max = Math.max(max, secondE - firstS + 1);
		}
		return max;
	}
}
