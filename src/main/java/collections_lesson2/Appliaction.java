package collections_lesson2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import service.ConsoleInterceptor;



public class Appliaction {
    
	public static void main(String[] args) {
		//intercepts System.out.println to log txt file
		ConsoleInterceptor.intercept(Appliaction.class.getName());
		
		List<String> animals = new ArrayList<String>();
		animals.add("Lion");
		animals.add("cat");
		animals.add("Dog");
		animals.add("Bird");
		
		List<Vehicle> vehicles = new LinkedList<Vehicle>();
		Vehicle vehicle2 = new Vehicle("Toyota", "Camery", 12000, false);
		
		vehicles.add(new Vehicle("Honda", "accord", 12000, false));
		vehicles.add(vehicle2);
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		printElements(vehicles);
		printElements(animals);
	}
	
	public static void printElements(List someList) {
		for(int i = 0; i < someList.size(); i++) {
			System.out.println(someList.get(i));
		}
	}

}
