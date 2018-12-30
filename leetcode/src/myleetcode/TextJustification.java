package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
        int letter = 0, space = 0, size = words.length;
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            letter = words[i].length();
            int min = letter;
            int end = i;
            while (end + 1 < size && min + words[end + 1].length() + 1 <= L) {
                end++;
                letter += words[end].length();
                min += words[end].length() + 1;
            }
            StringBuffer sb = new StringBuffer();
            if (end == i || end == size - 1) { // instead of end == size
                for(int j = i; j <= end; j++) {
                    sb.append(words[j]);
                    sb.append(" ");
                }
                addSpace(sb, L - min);
            } else {
                space = L - letter;
                int per = space / (end - i);
                int rem = space - per * (end - i);
                int j = i;
                for (; j < i + rem; j++) {
                    sb.append(words[j]);
                    addSpace(sb, per + 1);
                }
                for (; j <= end; j++) {
                    sb.append(words[j]);
                    addSpace(sb, per);
                }
            }
            res.add(sb.toString().substring(0, L)); // instead of substring(0, sb.length() - 1)
            i = end;
        }
        return res;
	}
	private void addSpace(StringBuffer sb, int len) {
	    for (int i = 0; i < len; i++) {
	        sb.append(" ");
	    }
	}
}
