package com.chandresh.practice.programs.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * Requirements: - Limit the amount of additional consumed memory to O(1).
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with 2,
 * 1 and 2 elements correspondingly, presents values in this order: {1, 2, 3, 4,
 * 5}
 */
public class IteratorFlattener<E> implements Iterator<E> {
	private List<E> mergedElements = new ArrayList<E>();
	private int currentIndex = -1;
	private boolean isValidCallToRemove = false;

	public IteratorFlattener(Iterator<Iterator<E>> root) {
		mergerIterators(root);
	}

	/**
	 * @param root
	 * merge all elements into a single list
	 */
	private void mergerIterators(Iterator<Iterator<E>> root) {
		if (root == null)
			return;

		while (root.hasNext()) {
			Iterator<E> temp = root.next();
			while (temp.hasNext()) {
				mergedElements.add(temp.next());
			}
		}

	}

	/**
	 * Returns {@code true} if the iteration has more elements.
	 *
	 * @return {@code true} if the iteration has more elements
	 */
	public boolean hasNext() {
		if (mergedElements == null || currentIndex + 1 >= mergedElements.size())
			return false;

		return true;
	}

	/**
	 * Returns the next element in the iteration.
	 *
	 * @return the next element in the iteration
	 * @throws NoSuchElementException
	 *             if the iteration has no more elements
	 */
	public E next() {
		if (mergedElements == null || currentIndex + 1 >= mergedElements.size())
			throw new NoSuchElementException("No more elements");
		isValidCallToRemove = true;
		return mergedElements.get(++currentIndex);
	}

	/**
	 * Removes from the underlying collection the last element returned by this
	 * iterator (optional operation). This method can be called only once per
	 * call to {@link #next}.
	 *
	 * @throws IllegalStateException
	 *             if the {@code next} method has not yet been called, or the
	 *             {@code remove} method has already been called after the last
	 *             call to the {@code next} method
	 */
	public void remove() {
		if (isValidCallToRemove) {
			this.mergedElements.remove(currentIndex);
			isValidCallToRemove = false;
		} else
			throw new IllegalStateException(
					"Call to remove is allowed only once per call to next");
	}

	public boolean contains(E e) {
		
		return this.mergedElements.contains(e);
	}
}
