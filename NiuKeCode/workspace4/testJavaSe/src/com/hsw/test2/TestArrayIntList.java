package com.hsw.test2;

import java.util.Iterator;

public class TestArrayIntList {
	public static void main(String[] args) {
		
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
