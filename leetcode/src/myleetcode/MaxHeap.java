package com.dilin.java.practice.imp.problems;

public class MaxHeap {

	private int size = 0;
	private int[] heap;
	public MaxHeap (int size) {
		this.heap = new int[size];
		this.size = size;
	}
	public void createHeap (int[] num) {
		this.heap = num;
		this.size = num.length;
		for (int i = num.length / 2; i >= 0; i--) {
			heapify(num, i);
		}
	}
	public void add (int n) {
		
		this.size++;
		if (heap.length < this.size) {
			int[] newHeap = new int[this.size * 2];
			for (int i = 0; i < this.heap.length; i++) {
				newHeap[i] = heap[i];
			}
			this.heap = newHeap;
		}
		this.heap[size - 1] = n;
		pushToTop(size - 1);
	}
	private void pushToTop (int n) {
		if (n == 0) return;
		int parent = (n - 1) / 2;
		if (this.heap[parent] < heap[n]) {
			swap(this.heap, parent, n);
			pushToTop(parent);
		}
	}
	public int getMax() {
		int temp = heap[0];
		heap[0] = heap[this.size - 1];
		this.size--;
		heapify(this.heap, 0);
		return temp;
	}
	private void heapify(int[] num, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int max = index;
		if (left < num.length && num[max] < num[left]) {
			max = left;
		}
		if (right < num.length && num[max] < num[right]) {
			max= right;
		}
		if (index != max) {
			swap (num, max, index);
			heapify(num, max);
		}
	}
	private void swap (int[] num, int i , int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
