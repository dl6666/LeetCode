package myleetcode;

public class Pow {
	public double pow(double x, int n) {
        if (Math.abs(x - 1.0) < 0.0000001) return x;
        if (Math.abs(x + 1.0) < 0.0000001) {
            if (n % 2 == 0) {
                return -x;
            } else {
                return x;
            }
        }
        if (n >= 0) {
            return powHelper(x, n);
        } else {
            return 1.0 / powHelper( x, -n);
        }
	}
	private double powHelper(double x, int n) {
	    if (n == 1) return x;
	    if (n == 0) return 1.0;
	    int div = n / 2;
	    int rem = n % 2;
	    double divAndDiv = powHelper(x, div);
	    return divAndDiv * divAndDiv * powHelper(x, rem);
	}
}
