package com.niltech.performance.cpu;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<Object> {
	private static long startTime = 0;
	private static int count = 0;
	private int myid;

	@Override
	public Object call() throws Exception {
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		System.out.println(this.getClass().getSimpleName() + "[" + myid + "] " + " thread Starts");
		for (int i = 1; i <= 10; i++) {
			System.out.println("ID[" + myid + "] Tick - " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long) Math.random() * 10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getClass().getSimpleName() + "[" + myid + "] " + " Ends - "
				+ (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
		return null;
	}

	public CallableTask() {
		this.myid = ++count;
	}

}
