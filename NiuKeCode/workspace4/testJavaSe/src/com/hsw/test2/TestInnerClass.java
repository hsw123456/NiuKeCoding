package com.hsw.test2;

import com.hsw.test2.Outer.Inner;

public class TestInnerClass {
			public static void main(String[] args) {
				Outer outer = new Outer();
				Inner inner = outer.new Inner();
				inner.info();
			}
}

class Outer{
	
	private Integer id;
	private String name;
	
	public void info(){
		System.out.println("outer's info method....");
	}
	
	public class Inner{
		
		public void info(){
			System.out.println("inner's info method>>>>>>");
		}
	}
}
