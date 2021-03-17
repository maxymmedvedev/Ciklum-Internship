package threadingLessons4;

import service.ConsoleInterceptor;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		//intercepts System.out.println to log txt file
	    ConsoleInterceptor.intercept(Application.class.getName());
		
		InventoryManager manager = new InventoryManager();
		
		Thread inventoryTask = new Thread(new Runnable() {
			
			@Override
			public void run() {
				manager.populateSoldProducts();
			}
		}) ;
		
Thread displayTask = new Thread(new Runnable() {
			
			@Override
			public void run() {
				manager.displaySoldProducts();
			}
		});

	inventoryTask.start();
	Thread.sleep(2000);	
	displayTask.start();
			
		
	}

}
