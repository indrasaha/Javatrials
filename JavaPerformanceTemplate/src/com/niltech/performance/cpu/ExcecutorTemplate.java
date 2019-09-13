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

class ExcecutorRunnableTask {
	private static long startTime = 0;

	public static void UsingExcecutorRunnableThread() {
		System.out.println("Main Starts");
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		RunnableTaskInvoker invoker = new RunnableTaskInvoker();
		invoker.execute(new RunnableTask());
		invoker.execute(new RunnableTask());
		invoker.execute(new RunnableTask());
		invoker.execute(new RunnableTask());
		System.out.println("Main Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}
}

class CallableTaskInvoker implements Executor {
	public void execute(CallableTask callableTask) throws Exception {
		System.out.println("Invoking Task " + callableTask.getClass().getSimpleName());
		String result = (String) callableTask.call();
		System.err.println(result);
	}

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub

	}
}

class ExcecutorCallableTask {
	private static long startTime = 0;

	public static void UsingExcecutorCallableThread() {
		System.out.println("Main Starts");
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);
		CallableTaskInvoker invoker = new CallableTaskInvoker();
		try {
			invoker.execute(new CallableTask());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}

}
