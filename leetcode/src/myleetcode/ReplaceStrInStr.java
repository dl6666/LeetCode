package myleetcode;

public class ReplaceStrInStr {
	public static void main(String[] args) {
		String s1 = "afdfaaadsafdsaf", s2 = "afdf",  s3 = "zz";
		System.out.println(replace(s1, s2, s3));
	}

	public static String replace(String s1, String s2, String s3) {
		int[] n = getNextArray(s2);
		StringBuffer sb = new StringBuffer();
		int i = 0, j = 0, len1 = s1.length(), len2 = s2.length();
		while (i < len1) {
			while (i < len1 && j < len2) {
				if (j == -1) {
					sb.append(s1.charAt(i++));
					j++;
				} else if (s1.charAt(i) == s2.charAt(j)) {
					i++;
					j++;
				} else {
					if (j != 0) {
						sb.append(s2.substring(0, j - n[j]));
					}
					j = n[j];
				}
			}
			if (j == len2) {
				sb.append(s3);
			} else {
				sb.append(s2.substring(0, j));
			}
			j = 0;
		}
		return sb.toString();
	}
	private static int[] getNextArray(String s) {
		int len = s.length();
		int[] n = new int[len];
		int k = -1, i = 0;
		n[0] = -1;
		while (i < len - 1) {
			if(k == -1 || s.charAt(i) == s.charAt(k)) {
				k++;
				i++;
				n[i] = k;
			} else {
				k = n[k];
			}
		}
		return n;
	}
}
