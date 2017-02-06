package com.chandresh.practice.programs.java.thread;

import java.util.concurrent.TimeUnit;


class RunnableInstance implements Runnable{

	ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	@Override
	public void run() {
		this.threadLocal.set("Chandresh" + Math.random());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.threadLocal.get());
	}
	
}

public class ThreadLocalTest {

	public static void main(String args[]){
		RunnableInstance ri = new RunnableInstance();
		Thread t1 = new Thread(ri);
		Thread t2 = new Thread(ri);
		
		t1.start();
		t2.start();
	}
}
