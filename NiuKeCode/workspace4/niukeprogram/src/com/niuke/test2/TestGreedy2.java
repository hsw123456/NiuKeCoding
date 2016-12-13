package com.niuke.test2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TestGreedy2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxTime = 0;
		int type = 0;
		Set<Herbal> herbals = new TreeSet();
		if (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] str = line.split(" ");
			try {
				maxTime = Integer.parseInt(str[0]);
				type = Integer.parseInt(str[1]);
			} catch (Exception e) {
				throw new RuntimeException("error");
			}
		}
			int t= 0;
			int v= 0;
		for (int i = 0; i < type; i++) {
			if (scanner.hasNextLine()) {
				t = scanner.nextInt();
				v= scanner.nextInt();
				herbals.add(new Herbal(v/t, v));
			}
		}

		System.out.println(maxValue(herbals, maxTime));

	}

	static class Herbal implements Comparable<Herbal> {

		private Integer key;
		private Integer value;

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Herbal(Integer key, Integer value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Herbal o) {
			return o.key-this.key;
		}

	}

	public static int maxValue(Set<Herbal> herbals, int maxTime) {
		int thiskey = 0;
		int thisval = 0;
		int keysum = 0;
		int valuesum = 0;

		for (Herbal h : herbals) {
			thiskey = h.getKey();
			thisval = h.getValue();
			if (keysum < maxTime&&thiskey<maxTime) {
				keysum += thiskey;
				valuesum += thisval;
			}
		}

		return valuesum;
	}
}