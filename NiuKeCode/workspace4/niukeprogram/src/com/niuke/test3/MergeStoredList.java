package com.niuke.test3;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author Administrator
 *思路： 建立一个空链表，，同时遍历list,list2,两者中的较小者添加到链表中
 */
public class MergeStoredList {
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(20);
		list1.next = new ListNode(30);
		list1.next.next = new ListNode(40);
		
		ListNode list2 = new ListNode(10);
		list2.next = new ListNode(15);
		list2.next.next = new ListNode(40);
		
		ListNode result = merge(list1, list2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	public static ListNode merge(ListNode list1, ListNode list2){
		ListNode head = new ListNode(-1);
		ListNode i = list1;
		ListNode j = list2;
		
		ListNode current = head;//指向新表的头结点,当添加一个元素到新表中时，将current向后移动一位
		//这种方式省略了大量的后移操作
		
		while(i != null && j!= null){
			if(i.val <= j.val){
				current.next = new ListNode(i.val);
				current = current.next;
				i = i.next;
			}else {
				current.next = new ListNode(j.val);
				current = current.next;
				j= j.next;
			}
		}
		
		if(i == null && j ==null){
			return head.next;
		}else if (i == null) {
			current.next = j;
			return head.next;
		}else{
			current.next = i;
			return head.next;
		}
	}
}
