package threadingLessons5_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import service.ConsoleInterceptor;

public class Application {

	public static void main(String[] args) {
		
		 //intercepts System.out.println to log txt file
		 ConsoleInterceptor.intercept(Application.class.getName());
		 
		 BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
		 
		 Thread t1 = new Thread(new Producer(questionQueue));
		 Thread t2 = new Thread(new Consumer(questionQueue));
		 
		 t1.start();
		 t2.start();	

		 	
	}

}
