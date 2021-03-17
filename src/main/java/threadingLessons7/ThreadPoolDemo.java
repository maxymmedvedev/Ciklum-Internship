package threadingLessons7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import service.ConsoleInterceptor;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		//intercepts System.out.println to log txt file
		ConsoleInterceptor.intercept(ThreadPoolDemo.class.getName());
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable processor = new MessageProcessor(2);
		executor.execute(processor);
		
		Runnable processor2 = new MessageProcessor(3);
		executor.execute(processor2);
		
		Runnable processor3 = new MessageProcessor(4);
		executor.execute(processor3);
		
		Runnable processor4 = new MessageProcessor(5);
		executor.execute(processor4);
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("submitted all tasks");

	}

}
