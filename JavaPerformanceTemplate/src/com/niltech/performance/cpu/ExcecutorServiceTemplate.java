package com.niltech.performance.cpu;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcecutorServiceTemplate {
	private static long startTime = 0;

	public static void main(String[] args) {
		UsingExcecutorService();
	}

	public static void UsingExcecutorService() {
		System.out.println("Main Starts");
		startTime = Instant.now().get(ChronoField.MILLI_OF_SECOND);

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(new RunnableTask());
		executorService.execute(new RunnableTask());
		executorService.execute(new RunnableTask());
		executorService.execute(new RunnableTask());
		executorService.execute(new RunnableTask());
		executorService.execute(new RunnableTask());
		executorService.execute(new RunnableTask());

		System.out.println("Main Ends - " + (Instant.now().get(ChronoField.MILLI_OF_SECOND) - startTime) + " ms");
	}
}
