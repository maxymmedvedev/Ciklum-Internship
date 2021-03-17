//Snapshot of lessons 1-2
package threadingLessons1_2;

import service.ConsoleInterceptor;

public class Application {

	public static void main(String[] args) {
		//intercepts System.out.println to log txt file
		//ConsoleInterceptor.intercept(Application.class.getName());
		
		System.out.println("Starting Thread 1");
		Thread t1 =new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					System.out.println("number: "+ i + " - " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}	 
		});
		t1.start();
		
		System.out.println("Starting Thread 1");
		Thread t2 =new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					System.out.println("number: "+ i + " - " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
			}	 
		});
		t2.start();
		
	}

}

class Task implements Runnable{
	
	String name;
	
	
	public Task(String name) {
		this.name = name;
	}


	public void run() {
		Thread.currentThread().setName(this.name);
		for(int i = 0; i < 1000; i++){
			System.out.println("number: "+ i + " - " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}
}