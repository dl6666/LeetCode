package com.dilin.java.practice.myLeetCode;

import java.util.HashMap;

public class LRUCache {
    private int capacity = 0;
	private HashMap<Integer, LRUNode> map = null;
	private LRUNode head = null;
	private int size = 0;
	public LRUCache (int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, LRUNode>();
		this.head = new LRUNode(0, 0);
		this.head.next = this.head;
		this.head.prev = this.head;
	}
	public int get(int key) {
		if (map.containsKey(key)) {
			moveToHead(map.get(key));
			return map.get(key).value;
		} else {
			return -1;
		}
	}
	public void set (int key, int value) {
		if (get(key) != -1) {
			moveToHead(map.get(key));
			map.get(key).value = value;
		} else {
			LRUNode newNode = new LRUNode(key, value);
			if (size < capacity) {
				size++;
			} else {
				LRUNode tail = this.head.prev;
				map.remove(tail.key);
				removeFromList(tail);
			}
			map.put(key, newNode);
			addToHead(newNode);
		}
	}
	private void removeFromList(LRUNode tail) {
		tail.prev.next = tail.next;
		tail.next.prev = tail.prev;
	}
	private void addToHead(LRUNode newNode) {
		this.head.next.prev = newNode;
		newNode.next = this.head.next;
		this.head.next = newNode;
		newNode.prev = this.head;
	}
	private void moveToHead(LRUNode lruNode) {
		lruNode.prev.next = lruNode.next;
		lruNode.next.prev = lruNode.prev;
		this.head.next.prev = lruNode;
		lruNode.prev = head;
		lruNode.next = this.head.next;
		this.head.next = lruNode;
	}
	private class LRUNode{
		public LRUNode next = null;
		public LRUNode prev = null;
		public int key = 0;
		public int value = 0;
		public LRUNode (int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
