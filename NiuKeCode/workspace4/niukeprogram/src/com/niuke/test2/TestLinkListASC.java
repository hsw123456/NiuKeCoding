package com.niuke.test2;

import java.util.Scanner;

public class TestLinkListASC {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = 0;
		int[] num;
		while(s.hasNext()){
			N = s.nextInt();
			LinkListASC list = new LinkListASC();
			for(int i=0; i<N;i++){
				list.addStored(Integer.parseInt(s.next()));
			}
			
			list.print();
			System.out.println();
		}
	}
	
	public static class LinkListASC{
		
		private ListNode front;
		
		public void addStored(int value){
			if(front== null || value<=front.data){
				front = new ListNode(value, front);
			}else{
				ListNode current = front;
				
				while(current.next!= null && current.next.data<value){
					current = current.next;
				}
				
				current.next = new ListNode(value, current.next);
			}
		}
		
		public void print(){
			if(front == null){
				System.out.println("[]");
			}else{
				ListNode current = front;
				System.out.print(current.data);
				while(current.next != null){
					current = current.next;
					System.out.print(" " + current.data);
				}
			}
		}
		
			public static class ListNode{
				int data;
				ListNode next;
				
				public ListNode(){
					this(0, null);
				}
				
				public ListNode(int data){
					this(data, null);
				}
				
				public ListNode(int data, ListNode next){
					this.data =data ;
					this.next = next;
				}
			}
		
	}

	
	

}
