package com.niuke.test3;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 给定一个链表的头指针 ListNode*
 * pHead，请返回重新排列后的链表的头指针。 注意：分割以后保持原来的数据顺序不变。
 * 
 * @author Administrator
 * 
 */
public class Partition {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(20);
		listNode.next = new ListNode(30);
		listNode.next.next = new ListNode(15);

		ListNode result = partition(listNode, 20);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public static ListNode partition(ListNode pHead, int x) {
		ListNode max = null;
		ListNode min = null;
		ListNode current = pHead;
		int data = 0;
		while (current != null) {
			data = current.val;
			if (data < x) {
				if (min == null) {
					min = new ListNode(data);
				} else {
					ListNode mHead = min;
					while (mHead.next != null) {
						mHead = mHead.next;
					}
					mHead.next = new ListNode(data);
				}
			} else {
				if (max == null) {
					max = new ListNode(data);
				} else {
					ListNode mHead = max;
					while (mHead.next != null) {
						mHead = mHead.next;
					}
					mHead.next = new ListNode(data);
				}

			}
			current = current.next;
		}

		if (min != null) {
			ListNode temp = min;
			while (temp.next != null) {
				temp = temp.next;
			}
			if (max != null) {
				temp.next = max;
			}

			return min;
		} else {
			return max;
		}
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}