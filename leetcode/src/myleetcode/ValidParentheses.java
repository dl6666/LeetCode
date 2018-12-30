package com.dilin.java.practice.myLeetCode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char curt = s.charAt(i);
            if (curt == '(' || curt == '[' || curt == '{') {
                stack.push(curt);
            } else if (!stack.isEmpty()) {
                char top = stack.pop();
                if ((curt == ')' && top != '(') || (curt == '}' && top != '{') || (curt == ']' && top != '[')) return false;
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
