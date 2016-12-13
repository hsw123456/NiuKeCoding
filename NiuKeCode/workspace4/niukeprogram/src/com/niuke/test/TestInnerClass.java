package com.niuke.test;

/*
 * 成员内部类：
 * 	是外部类的一个成员：1.可以修饰符4个（private，protected,default public)
 * 					static final ，可以调用外部类的属性方法
 * 	是一个类：abstract
 * 
 * 内部类需要掌握的知识点：
 * 1：如何创建成员内部类的对象(如：如何创建静态内部类和非静态内部类的对象)
 * 2：如何区分调用外部类内部类的变量
 * 3：局部内部类的基本使用
 * 
 */
public class TestInnerClass {
		public static void main(String[] args) {
			//创建静态内部类的对象，可以直接通过外部类调用内部类的静态构造器
			Person1.Dog  d = new Person1.Dog();
			
			Person1 p = new Person1();
			Person1.Bird b = p.new Bird();
			b.info();
			b.setName("杜鹃");
		}
}

class Person1 {
	String name = "韩梅梅";
	int age;
	//非静态内部类
	 class Bird {
		String name = "黄鹂";
		int id;
		

		public void setName(String name) {
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Person1.this.name);
		}

		public Bird() {

		}

		public void info() {
			show();
		}
	}
	//静态内部类
	static class Dog{
		
	}

	public void show() {
		System.out.println("我是外部类的show方法，成员内部类可以调用我！");
	}
}
