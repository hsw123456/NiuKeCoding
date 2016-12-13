package com.niuke.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestCurrentTiem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String rname;
		String start;
		String consumeTime;
		String line;
		String[] splitline;
		Records records;
		ArrayList<Records> listRecord= new ArrayList<TestCurrentTiem.Records>();

		while (input.hasNextLine()) {
			String resString = input.nextLine();
			line = resString.trim().replaceAll("[ ]+", " ");
			splitline = line.split(" ");
			rname = splitline[0];
			start = splitline[1] + splitline[2];
			consumeTime = splitline[3];
			records = new Records(rname, start, consumeTime, resString);
			listRecord.add(records);
		}
		
		Collections.sort(listRecord);
		for(Records r:listRecord){
			System.out.println(r.resString);
		}

	}

	static class Records implements Comparable<Records> {

		private String name;
		private String startTime;
		private String consume;
		private String resString;

		public Records(String name, String startTime, String consume,
				String resString) {
			super();
			this.name = name;
			this.startTime = startTime;
			this.consume = consume;
			this.resString = resString;
		}

		@Override
		public int compareTo(Records o) {
			int len1 = this.startTime.length();
			int len2 = o.startTime.length();
			if(len1 != len2){
				return len1-len2;
			}
			
			int temp = this.startTime.compareTo(o.startTime);
			if(temp !=0){
				return temp;
			}
			
			len1 = this.consume.length();
			len2 = o.consume.length();
			if(len1 !=len2){
				return len1 - len2;
			}
			
			return this.consume.compareTo(o.consume);
			
		}

	}

}
