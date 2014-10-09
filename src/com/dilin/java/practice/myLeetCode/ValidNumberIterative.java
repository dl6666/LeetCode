package com.dilin.java.practice.myLeetCode;

public class ValidNumberIterative {
	public boolean isNumber(String s) {
		int i = 0, len = s.length();
		boolean dec = false, digit = false, e = false;
		while (i < len && s.charAt(i) == ' ') {
		    i++;
		}
		while (i < len) {
		    char curt = s.charAt(i);
		    if (curt == '.') {
		        if (dec) return false;
		        else dec = true;
		    } else if (curt == 'e') {
		        if (e || !digit) {
		            return false;
		        } else {
		            e = true;
		            digit = false;
		            dec = true;
		        }
		    } else if (curt == ' ') {
		        break;
		    } else if (curt >= '0' && curt <= '9') {
		        digit = true;
		    } else if (s.charAt(i) == '+' || s.charAt(i) == '-'){// forget about it
		        if (i != 0 && s.charAt(i - 1) != ' ' && s.charAt(i - 1) != 'e') {
		            return false;
		        }
		    } else {
		        return false;
		    }
		    i++;
		}
		while (i < len) {
		    if (s.charAt(i) != ' ') return false;
		    i++;
		}
		return digit;
	}
}
