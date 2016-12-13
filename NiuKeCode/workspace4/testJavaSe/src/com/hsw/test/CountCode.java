package com.hsw.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountCode {

	static long normalLines;
	static long comentLines;
	static long whiteLines;

	public static void main(String[] args) {
		File f = new File("C:\\Users\\Administrator\\Desktop\\file");
		File[] codeFiles = f.listFiles();

		for (File file : codeFiles) {
			if (file.getName().matches(".*\\.java")) {
				parse(file);
			}
		}

		System.out.println("normalLine: " + normalLines);
		System.out.println("commentLine: " + comentLines);
		System.out.println("whiteLine: " + whiteLines);

	}

	private static void parse(File file) {
		BufferedReader bfr = null;
		boolean comment = false;
		try {
			bfr = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bfr.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$")) {
					whiteLines++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					comentLines++;
					comment = true;
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					comentLines++;
				}else if (true == comment) {
					comentLines++;
					if (line.endsWith("*/")) {
						comment = false;
					}
				} else if (line.startsWith("//")) {
					comentLines++;
				} else {
					normalLines++;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bfr != null) {
				try {
					bfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
