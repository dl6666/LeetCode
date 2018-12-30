package myleetcode;

public class CompareStrings {

	public static void main(String[] args) {
		System.out.println(compareStrings("A",""));
	}
	public static boolean compareStrings(String A, String B) {
        int[] count = new int[26];
        for (int i = 0; i < B.length(); i++) {
            count[B.charAt(i) - 'A']++;
        }
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i) - 'A']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) return false;
        }
        return true;
    }
}
