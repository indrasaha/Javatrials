package com.niltech.performance.cpu;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ExcecutorTemplate {

	public static void main(String[] args) {
		ExcecutorRunnableTask.UsingExcecutorRunnableThread();
		ExcecutorCallableTask.UsingExcecutorCallableThread();
	}
}

class RunnableTaskInvoker implements Executor {
	@Override
	public void execute(Runnable command) {
		System.out.println("Invoking Task " + command.getClass().getSimpleName());
		command.run();
	}
}

class ExcecutorRunnableTask implements Runnable {
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

	public ExcecutorRunnableTask() {
		this.myid = ++count;
	}

	public static void UsingExcecutorRunnableThread() {
		System.out.println("Main Starts");
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		RunnableTaskInvoker invoker = new RunnableTaskInvoker();
		invoker.execute(new ExcecutorRunnableTask());
		invoker.execute(new ExcecutorRunnableTask());
		invoker.execute(new ExcecutorRunnableTask());
		invoker.execute(new ExcecutorRunnableTask());
		System.out.println("Main Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}
}

class CallableTaskInvoker implements Executor {
	public void execute(ExcecutorCallableTask callableTask) throws Exception {
		System.out.println("Invoking Task " + callableTask.getClass().getSimpleName());
		String result = callableTask.call();
		System.err.println(result);
	}

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub

	}
}

class ExcecutorCallableTask implements Callable<Object> {
	private static long startTime = 0;
	private static int count = 0;
	private int myid;

	@Override
	public String call() throws Exception {
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
		//System.out.println(this.getClass().getSimpleName() + "[" + myid + "] " + " Ends - "
		//		+ (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
		return ""+this.getClass().getSimpleName() + "[" + myid + "] " + " Ends - "
		+ (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms";
	}

	public ExcecutorCallableTask() {
		this.myid = ++count;
	}

	public static void UsingExcecutorCallableThread() {
		System.out.println("Main Starts");
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		CallableTaskInvoker invoker = new CallableTaskInvoker();
		try {
			invoker.execute(new ExcecutorCallableTask());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}

}
