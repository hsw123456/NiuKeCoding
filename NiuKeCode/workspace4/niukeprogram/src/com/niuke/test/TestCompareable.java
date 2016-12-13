package com.niuke.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCompareable {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		
		Person p1 = new Person("hsw", 21);
		Person p2 = new Person("hsf", 22);
		Person p3 = new Person("hsj", 18);
		Person p4 = new Person("hss", 27);
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		Collections.sort(persons);
		System.out.println(persons);
		
		Dog dog1 = new Dog("aa",25);
		Dog dog2 = new Dog("bb",22);
		Dog dog3 = new Dog("cc",24);
		Dog dog4 = new Dog("dd",28);
		
		Dog[] dogs = new Dog[4];
		dogs[0] = dog1;
		dogs[1] = dog2;
		dogs[2] = dog3;
		dogs[3] = dog4;
		
		Arrays.sort(dogs,new SortByWeightAsc());
		System.out.println(Arrays.asList(dogs));
		
		Arrays.sort(dogs,new SortByWeightDesc());
		System.out.println(Arrays.asList(dogs));
	}

}

class Person implements Comparable<Person>{
	
	private String name;
	private int age;

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.age-this.age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
