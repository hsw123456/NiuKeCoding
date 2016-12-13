package com.niuke.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestRecords {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String name;
		long startTime;
		Double consume;
		String start;
		SimpleDateFormat format = new SimpleDateFormat(
				"YYYY-MM-DD HH:mm:ss");
		List<Records> list = new ArrayList<TestRecords.Records>();
		while (scanner.hasNext()) {
			name = scanner.next();
			try {
				
				start = scanner.next();
				startTime = format.parse(start.substring(0,start.length()-3)).getTime();
				startTime += Integer.parseInt(start.substring(start.length()-3));
				
				consume = scanner.nextDouble();
				
				Records records = new Records(name, startTime, consume);
				list.add(records);
			} catch (Exception e) {
				throw new RuntimeException("出错了");
			}
		}

		Collections.sort(list);
		outPrint(list);

	}

	public static void outPrint(Collection<? extends Records> c) {
		for (Records r : c) {
			System.out.print(r.name + " ");
			System.out.print(r.startTime + " ");
			System.out.print(r.consume + " ");
		}
	}

	static class Records implements Comparable<Records> {
		private String name;
		private long startTime;
		private Double consume;
		
		

		public Records(String name, long startTime, Double consume) {
			super();
			this.name = name;
			this.startTime = startTime;
			this.consume = consume;
		}



		@Override
		public int compareTo(Records o) {
			if (this.consume != o.consume) {
				if (this.consume > o.consume) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return this.startTime < o.startTime ? 1: -1;
			}
		}

	}

}
