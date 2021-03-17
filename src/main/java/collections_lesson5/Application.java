package collections_lesson5;

import java.util.Map;
import java.util.TreeMap;

import service.ConsoleInterceptor;

public class Application {

	public static void main(String[] args) {
		//intercepts System.out.println to log txt file
		ConsoleInterceptor.intercept(Application.class.getName());
		
		TreeMap<String, String> dictionary = new TreeMap<String, String>();
		dictionary.put("Brave" , "ready to face and endure danger or pain; showing courage");
		dictionary.put("Brilliant" , "exceptionally clever or talented");
		dictionary.put("Joy" , "a feeling of great pleasure and happiness");
		dictionary.put("Confidence" , "the feeling or belief that one can rely on someone or something");

		dictionary.put("Brilliant" , "xxxxxxxxxxxxxxx");
		
		for(Map.Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
