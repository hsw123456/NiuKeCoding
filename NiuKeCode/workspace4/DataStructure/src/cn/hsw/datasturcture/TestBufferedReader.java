package cn.hsw.datasturcture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TestBufferedReader {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(
					"C:\\Users\\Administrator\\Desktop\\test.txt"));
			String line = bfr.readLine();
			line= line.trim();
			System.out.println(line);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
