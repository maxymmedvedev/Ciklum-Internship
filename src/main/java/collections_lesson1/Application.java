package collections_lesson1;

import java.util.ArrayList;
import java.util.LinkedList;

import service.ConsoleInterceptor;

public class Application {
	
    public static void main(String[] args) {
    	//intercepts System.out.println to log txt file
    	//ConsoleInterceptor.intercept(Application.class.getName());
    	
    	ArrayList<String> words = new ArrayList<String>();
    	words.add("hello");
    	words.add("there");
    	words.add("10");
    	
    	String item1 = words.get(2);
    	
    	System.out.println(item1);
    
    	LinkedList<Integer> numbers =new LinkedList<Integer>();
    	numbers.add(100);
    	numbers.add(200);
    	numbers.add(45);
    	numbers.add(1000);
    	
    	numbers.removeFirst();
    	
    	for(int number : numbers) {
    		System.out.println(number);
    	}
    }

}
