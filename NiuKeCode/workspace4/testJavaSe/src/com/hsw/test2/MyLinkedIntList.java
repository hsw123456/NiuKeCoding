package com.hsw.test2;

public class MyLinkedIntList {
	
	private ListNode front;
	
	public MyLinkedIntList() {
		front = null;
	}
	
	
	//将value追加到链表的尾部
	public void add(int value){
		if(front == null){
			front = new ListNode(value);
		}else {
			ListNode current = front;
			
			while(current.next != null){
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}
	
	//获取指定位置的元素
	public int get(int index){
		ListNode current = front;
		for(int i=0; i<index; i++){
			current = current.next;
		}
		
		return current.data;
	}
	//在指定位置追加元素
	public void add(int index, int value){
		if(index == 0){
			front = new ListNode(value,front);
		}else {
			ListNode current = front;
			for(int i=0; i<index-1; i++){
				current = current.next;
			}
			current.next = new ListNode(value, current.next);
		}
	}
	
	//删除指定位置的元素
	public int remove(int index){
		
		if(index == 0){
			int result = front.data;
			front = front.next;
			return result;
		}else{
			ListNode current = front;
			for(int i=0; i<index-1; i++){
				current = current.next;
			}
			int result = current.next.data;
			current.next = current.next.next;
			return result;
		}
	}
	
	
	
	
	
	@Override
	public String toString() {
		if(front == null){
			return "[]";
		}else {
			String result = "["+front.data;
			ListNode current = front.next;
			while(current !=null){
				result += "," +current.data;
				current = current.next;
			}
			
			result += "]";
			return result;
		}
		
	}








	private static class ListNode{
		int data;
		ListNode next;
		
		private ListNode(){
			this(0, null);
			
		}
		
		private ListNode(int data){
			this(data, null);
		}
		
		private ListNode(int data,ListNode next){
			this.data = data;
			this.next = next;
		}
	}

}
