package myleetcode;

import java.util.LinkedList;

public class SimplifyPath {

	public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        int len = path.length();
        LinkedList<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i< len; i++) {
            char curt = path.charAt(i);
            if (curt == '/') continue;
            int start = i;
            while (i < len && path.charAt(i) != '/') i++;
            String buff = path.substring(start, i);
            if (buff.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (!buff.equals(".")) {
                stack.add(buff);
            }
        }
        if (stack.isEmpty()) return "/";
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append("/" + stack.poll());
        }
        return sb.toString();
    }
}
