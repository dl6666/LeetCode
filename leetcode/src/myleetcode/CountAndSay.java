package myleetcode;

public class CountAndSay {

	public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            int j = 0, len = s.length();
            while (j < len) {
                char curt = s.charAt(j);
                int count = 1;
                while (j + 1 < len && s.charAt(j + 1) == curt) {
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(curt);
                j++;
            }
            s = sb.toString();
        }
        return s;
    }
}
