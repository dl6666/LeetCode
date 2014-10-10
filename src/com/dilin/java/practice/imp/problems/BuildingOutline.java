package com.dilin.java.practice.imp.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BuildingOutline {

	public int[] getOutline (List<Building> buildings) {
		Comparator<Time> compSort = new Comparator<Time>() {
			@Override
			public int compare(Time b1, Time b2) {
				return b1.time - b2.time;
			}
		};
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(buildings.size());
		int minStart = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE;
		List<Time> times = new LinkedList<Time>();
		for (int i = 0; i < buildings.size(); i++) {
			Building curt = buildings.get(i);
			times.add(new Time(curt.start, 0, curt.height));
			times.add(new Time(curt.end, 1, curt.height));
			minStart = Math.min(curt.start, minStart);
			maxEnd = Math.max(curt.end, maxEnd);
		}

		Collections.sort(times, compSort);
		int[] res = new int[maxEnd - minStart + 1];
		for (int i = 0; i < res.length; i++) {
			while (i + minStart >= times.get(0).time) {
				Time curt = times.remove(0);
				if (curt.bE == 1) {
					que.remove(curt.height);
				} else if (curt.bE == 0) {
					que.add(curt.height);
				}
			}
			res[i] = que.peek();
		}
		return res;
	}
	private class Time {
		public int time;
		public int bE;
		public int height;
		public Time (int time, int bE, int height) {
			this.time = time;
			this.bE = bE;
			this.height = height;
		}
	}
	private class Building {
		public int start;
		public int end;
		public int height;
	}
}
