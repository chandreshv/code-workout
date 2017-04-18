package com.chandresh.practice.programs.java;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;

public class BlockingQueueTest {
	@Test
	public void getCurrentSize_noParam_zero() {
		BlockingQueue<String> bQueue = new BlockingQueue<String>(
				new LinkedList<String>());
		int actual = bQueue.getCurrentSize();
		assertEquals(0, actual);
	}
	
	
	/**
	 * This method execute two tasks using the same BlockingQueue instance along with the main thread.
	 * As the execution sequence between the threads cannot be guaranteed, 
	 * thread will wait to be notified in case of queue is empty or full while trying to pull or push respectively.
	 * 
	 * There might occur a situation where, all running threads might go into wait state and there is no one to notify them.
	 */
	@Test
	public void pull_PushPullQueueWith1Capacity_void() {
		Executor exec = Executors.newCachedThreadPool();
		BlockingQueue<String> queue = new BlockingQueue<String>(
				new ArrayBlockingQueue<String>(1));
		Runnable task1 = new TestThread(queue);
		Runnable task2 = new TestThread(queue);
		exec.execute(task1);
		exec.execute(task2);
		queue.pull();
		queue.push("D");
		queue.pull();
		queue.push("F");

		// String actual = bQueue.pull();
	}

}

class TestThread implements Runnable {
	BlockingQueue<String> queue;

	public TestThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			this.queue.push("A");
			this.queue.pull();
		}
	}

}