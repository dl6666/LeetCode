package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
//	recursive solution
//	public List<String> generateParenthesis(int n) {
//        if (n <= 0) return new ArrayList<String>();
//        LinkedList<Wrapper> res = new LinkedList<Wrapper>();
//        res.add(new Wrapper(new StringBuffer("("), 1));
//        while (res.get(0).sb.length() < 2 * n) {
//            int len = res.size();
//            for (int i = 0; i < len; i++) {
//                Wrapper curt = res.get(i);
//                int left = curt.count;
//                int right = curt.sb.length() - left;
//                if (left > right) {
//                    if (left < n) {
//                        Wrapper newOne = new Wrapper(curt.sb, curt.count);
//                        newOne.sb.append(")");
//                        res.add(newOne);
//                        curt.sb.append("(");
//                        curt.count++;
//                    } else {
//                        curt.sb.append(")");
//                    }
//                } else if (left < n) {
//                    curt.sb.append("(");
//                    curt.count++;
//                } else {
//                    curt.sb.append(")");
//                }
//            }
//        }
//        List<String> ress = new ArrayList<String>();
//        while (!res.isEmpty()) {
//            Wrapper curt = res.poll();
//            ress.add(curt.sb.toString());
//        }
//        return ress;
//    }
//    private class Wrapper {
//        public StringBuffer sb = null;
//        public int count = 0;
//        public Wrapper (StringBuffer sb, int count) {
//            this.sb = new StringBuffer(sb);
//            this.count = count;
//        }
//    }
//    
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        constructSeq(res, new StringBuffer(), n, 0);
        return res;
    }
    
    private void constructSeq(List<String> res, StringBuffer sb, int n, int count) {
        int left = count;
        int right = sb.length() - count;
        if (left == n && right == n) {
            res.add(sb.toString());
        } else if (sb.length() == 2 * n){
            return;
        } else {
            if (left < n) {
                constructSeq(res, sb.append("("), n, count + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (left > right) {
                constructSeq(res, sb.append(")"), n, count);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
