package com.dilin.java.practice.myLeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsInALine {
	public int maxPoints(Point[] points) {
        int size = points.length, inf = 0, zero = 0, same = 0, max = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < size; i++) {
            Point first = points[i];
            inf = 0;
            zero = 0;
            same = 1;
            map.clear();
            for (int j = i + 1; j < size; j++) {
                Point second = points[j];
                if (first.x == second.x) {
                    if (first.y == second.y) {
                        same++;
                    } else {
                        inf++;
                    }
                } else {
                    if (first.y != second.y) {
                        double slope = 1.0 * (first.y - second.y) / (first.x - second.x);
                        if (map.containsKey(slope)) {
                            map.put(slope, map.get(slope) + 1);
                        } else {
                            map.put(slope, 1);
                        }
                    } else {
                        zero++;
                    }
                }
            }
            int tempMax = Math.max(inf, zero);
            for (int val : map.values()) {
                tempMax = Math.max(val, tempMax);
            }
            max = Math.max(tempMax + same, max);
        }
        return max;
    }
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
}
