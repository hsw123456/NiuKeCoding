package com.niuke.test;

import java.util.Comparator;

public class SortByWeightAsc implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.getWeight() - o2.getWeight();
	}

}

class SortByWeightDesc implements Comparator<Dog> {
	
	@Override
	public int compare(Dog o1, Dog o2) {
		return -(o1.getWeight() - o2.getWeight());
	}
}

class Dog {
	private String name;
	private int weight;

	public Dog(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", weight=" + weight + "]";
	}

}
