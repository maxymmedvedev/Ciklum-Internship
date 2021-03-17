package lambdas_Lesson1_2;

import collections_lesson5.Application;
import service.ConsoleInterceptor;

public class App {

	public static void main(String[] args) {
		//intercepts System.out.println to log txt file
		ConsoleInterceptor.intercept(App.class.getName());
		
		Human tom = new Human();
		walker(tom);

		Robot wale = new Robot();
		walker(wale);

		walker(() -> System.out.println("Custom object walking... "));

		Walkable aBlockOfCode = () -> {
			System.out.println("Custom object walking... ");
			System.out.println("the object tripped... ");
		};

		walker(aBlockOfCode);

		ALambdaInterface helloVar = () -> System.out.println("hello there");
		Calculate sumVar = (a, b) -> a + b;
		helloVar.someMethod();
		System.out.println(sumVar.compute(4, 6));

		Calculate nonZeroDivider = (a, b) -> {
			if (a == 0) {
				return 0;
			}
			return a / b;
		};

		System.out.println(nonZeroDivider.compute(10, 5));
		
		MyGenericInterface<String> reverser = (s) -> {
			String result = "";
			for (int i = s.length() - 1; i >= 0; i--) {
				result = result + s.charAt(i);
			}
			return result;
		};
		
		System.out.println(reverser.work("Vehicle")) ;
		
		MyGenericInterface<Integer> computedNumber = (n) -> {int result = 1;
		for(int i = 1; i <= n; i++) {
			result = i*result;
		}
		return result;
		};
		System.out.println(computedNumber.work(10));

	}

	public int nonZeroDivide(int arg1, int arg2) {
		if (arg1 == 0) {
			return 0;
		}
		return arg1 / arg2;
	}
 	String reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result = result + str.charAt(i);
		}
		return result;
	}

	private static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}

	public void sayHello() {
		System.out.println("hello there");
	}

	public int sum(int arg1, int arg2) {
		return arg1 + arg2;
	}

	public int factorial(int num) {
		int result = 1;
		for(int i = 1; i <= num; i++) {
			result = i*result;
		}
		return result;
	}
}

interface Calculate {
	public int compute(int a, int b);
}

interface MyGenericInterface<T>{
	public T work(T t);
}

interface NumberWorker {
	public int compute(int a);
}
