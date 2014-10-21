package com.dilin.java.practice.imp.problems;

import java.util.Iterator;

public class FlattenIterator<T> {
	private Iterator<Iterator<T>> iterators;
	private Iterator<T> it;
	public FlattenIterator (Iterator<Iterator<T>> its) {
		this.iterators = its;
		this.it = null;
	}
	public boolean hasNext() {
		while ((it == null || !it.hasNext()) && iterators.hasNext()) {
			it = iterators.next();
		}
		return it != null && it.hasNext();
	}
	public T next() {
		if (hasNext()) {
			return it.next();
		}
		return null;
	}
}
