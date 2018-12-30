package myleetcode;

public class PlusOne {

	public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] > 9) {
                digits[i - 1] += digits[i] / 10;
                digits[i] %= 10;
            }
        }
        if (digits[0] > 9) {
            int[] temp = new int[digits.length + 1];
            temp[0] = digits[0] / 10;
            digits[0] %= 10;
            for (int i = 1; i < temp.length; i++) {
                temp[i] = digits[i - 1];
            }
            digits = temp;
        }
        return digits;
    }
}
