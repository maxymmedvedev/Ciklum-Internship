package lambdas_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import collections_lesson5.Application;
import service.ConsoleInterceptor;

public class App {

	public static void main(String[] args) throws IOException {
		
		//intercepts System.out.println to log txt file
		ConsoleInterceptor.intercept(App.class.getName());
		
		Stream.of("Hello", "bottle", "Africa")
			.sorted()
			.findFirst()
			.ifPresent((x) -> System.out.println(x));	
		
		
		Arrays.stream(new int[] {2,4,6,8,10})
				.map((x) -> x*x)
				.average().ifPresent(n -> System.out.print(n));
		System.out.println();
		
		
		List<String> listOfItems = Arrays.asList("Computer", "Toothpaste", "Box",
												"Pencil", "Car", "Toy");
		listOfItems.stream()
			.map(x ->x.toLowerCase())
			.filter(x -> x.startsWith("c"))
			.sorted()
			.forEach(x -> System.out.print(x + ", "));

	}

}
