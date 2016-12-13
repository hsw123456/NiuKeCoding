package com.hsw.test;

public class Main{
	public static void main(String[] args) {
		
		A a  = new A("shw",25);
		
		
	}
}


class A {
	private String name;
	private int age;
	
	
	
	public A(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public A() {
	}


	public void info(){
		System.out.println(name+":"+age);
	}

}

class B extends A{
	private String school= "Qinghua University";
	
	
	public B(String name, int age, String school) {
		super(name, age);
		this.school = school;
	}


	@Override
	public void info() {
		super.info();
		System.out.println("SCHOOL:" + school);
		
	}
}