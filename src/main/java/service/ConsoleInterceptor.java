package service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConsoleInterceptor {
	//using absolute path for saving time
	//!!! redefine before using it yourself!
	static String logsPath = "C:\\my project\\Ciklum Internship\\Day1_JavaSE\\logs";
	
	public static void intercept(String name) {
		PrintStream out;
		try {
			out = new PrintStream(
			        new FileOutputStream(logsPath + "\\"+ name +"Logs.txt" , true), true);
			System.setOut(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
