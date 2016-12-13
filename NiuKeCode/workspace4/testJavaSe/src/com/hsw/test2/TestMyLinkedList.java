package com.hsw.test2;

public class TestMyLinkedList {
	
	public static void main(String[] args) {
		MyLinkedIntList list = new MyLinkedIntList();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		
		
		System.out.println(list);
		System.out.println(list.remove(0));
		System.out.println(list);
	}

}
