package com.chandresh.practice.programs.java;

import java.util.Queue;

/**
 * Provides waiting thread-safe access to a java.util.Queue instance.
 *
 * Requirements: - Usage of API from java.util.concurrent packageis prohibited.
 * - Limit the amount of additional consumed memory to O(1). - The
 * implementation is supposed to be acceptable for usage in a highly
 * multi-thread environment.
 *
 * Useful tips a.k.a. common pitfalls: - Please note that you do not need to
 * implement java.util.Queue. - Readiness to accept or provide elements is
 * solely dependent on the underlying queue. Any additional queue capacity
 * limitations break contract defined in the javadoc.
 */
public class BlockingQueue<E> {
	private Queue<E> queue;

	/**
	 * @param queue
	 *            The underlying "wrapped" queue.
	 */
	public BlockingQueue(Queue<E> queue) {
		this.queue = queue;
	}

	/**
	 * Inserts the specified element into the underlying queue, waiting if
	 * necessary for the underlying queue to be ready to accept new elements.
	 * 
	 * @param e
	 *            the element to insert.
	 */
	public void push(E e) {
		if (e == null)
			return;

		synchronized (this) {
			
			while (true) {
				try {
					if (this.queue.add(e)) {
						System.out.println("Successfully added "+e);
						break;
					}
				} catch (IllegalStateException ise) {
					try {
						System.out.println("Waiting for queue to get space");
						wait();
					} catch (InterruptedException e1) {
						System.out.println("Interrupted in push");
					}
				}
			}
			notifyAll();
		}
	}

	/**
	 * Retrieves and removes the head of the underlying queue, waiting if
	 * necessary until it is capable of providing an element.
	 * 
	 * @return the retrieved element
	 */
	public E pull() {
		E result = null;
		synchronized (this) {
			while (this.queue.size() == 0) {
				try {
					System.out.println("Queue is empty. Thread will wait for an element to be added");
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interrupted in pull");
				}
			}
			
			result = this.queue.poll();
			System.out.println("Successfully pulled "+result);
			notifyAll();
		}

		return result;
	}

	/**
	 * @return: current size of the underlying queue
	 */
	public int getCurrentSize() {
		return this.queue.size();
	}
}
