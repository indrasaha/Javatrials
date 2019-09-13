package com.niltech.performance.cpu;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

public class ThreadTemplate {

	public static void main(String[] args) {
		RunnableThread.UsingRunnnable();
		SelfExtendedThread.UsingSelfExtendedThread();
		ControllableThread.UsingControllableThread();
	}
}

class RunnableThread implements Runnable {
	private static long startTime = 0;
	private static int count = 0;
	private int myid;

	@Override
	public void run() {
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
	}

	public RunnableThread() {
		this.myid = ++count;
	}
	
	public static void UsingRunnnable() {
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		System.out.println("Main thread Starts");
		new Thread(new RunnableThread()).start();
		new Thread(new RunnableThread()).start();
		new Thread(new RunnableThread()).start();
		System.out
				.println("Main thread Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}
}


class SelfExtendedThread extends Thread {
	private static long startTime = 0;
	private static int count = 0;
	private int myid;

	@Override
	public void run() {
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
	}

	public SelfExtendedThread() {
		this.myid = ++count;
		this.start();
	}
	
	public static void UsingSelfExtendedThread() {
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		System.out.println("Main thread Starts");
		new Thread(new SelfExtendedThread());
		new Thread(new SelfExtendedThread());
		new Thread(new SelfExtendedThread());
		System.out
				.println("Main thread Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}
}

class ControllableThread implements Runnable {
	private static long startTime = 0;
	private static int count = 0;
	private int myid;

	@Override
	public void run() {
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
	}

	public ControllableThread() {
		this.myid = ++count;
	}
	
	public static void UsingControllableThread() {
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		System.out.println("Main thread Starts");
		Thread t1 = new Thread(new ControllableThread());
		Thread t2 = new Thread(new ControllableThread());
		Thread t3 = new Thread(new ControllableThread());
		
		// Staring or Controlled from outside
		t1.start();
		t2.start();
		t3.start();
		
		System.out
				.println("Main thread Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}
}
