package collections_lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import service.ConsoleInterceptor;

public class Application {

	public static void main(String[] args) {
		//intercepts System.out.println to log txt file
		ConsoleInterceptor.intercept(Application.class.getName());
		
		HashSet<Employee> hashSet = new HashSet<Employee>();
		hashSet.add(new Employee("Mike", 3500 , "Accounting"));
		hashSet.add(new Employee("Paul", 3000 , "Admin"));
		hashSet.add(new Employee("Peter", 4000 , "IT"));
		hashSet.add(new Employee("Angel", 2000 , "Maint"));
		
		ArrayList<Employee> myList = new ArrayList<Employee>(hashSet);
		
		Collections.sort(myList);
		
		System.out.println(myList);
		
	}

}
