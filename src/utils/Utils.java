package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.IIOException;

public class Utils {
	
	//load file txt -> string
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) 
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	//chuyen string -> int
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
