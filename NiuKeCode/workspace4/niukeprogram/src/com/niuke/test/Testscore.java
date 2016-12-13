package com.niuke.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Testscore {
	
	public static  class Student {

		private int id;
		private int score;

		public Student(int id, int score) {
			super();
			this.id = id;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", score=" + score + "]";
		}

	}
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();

		int[] id = new int[count];
		int[] score = new int[count];
		Student[] students = new Student[count];
		for (int i = 0; i < count; i++) {
			students[i]= new Student(input.nextInt(), input.nextInt());
		}
		
		Arrays.sort(students,new SortBySocreAsc());
		for(int i = 0; i<students.length; i++){
			System.out.println(students[i].id+" "+ students[i].score);
		}

	}

	public static class SortBySocreAsc implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.score ==  o2.score){
				return o1.id-o2.id;
			}else{
				return o1.score- o2.score;
			}
		}

	}

}

