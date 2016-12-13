package com.hsw.test2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import sun.org.mozilla.javascript.internal.ast.ThrowStatement;

public class MyArrayList<E> {

	private Object[] elementData;// 一个未满载的数组
	// 记录数组中元素的个数
	private int size;

	public MyArrayList() {
		this(10);
		size = 0;
	}

	public MyArrayList(int capacity) {
		elementData = new Object[capacity];
		size = 0;
	}

	// 添加元素到列表
	public void add(E value) {
		ensureCapacity(size + 1);
		elementData[size] = value;
		size++;
	}

	// 添加元素到指定位置
	public void add(int index, E value) {
		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		elementData[index] = value;
		size++;
	}

	// 清除所有元素
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = 0;
		}
		size = 0;
	}

	// 获取指定位置的元素
	public E get(int index) {
		return (E) elementData[index];
	}

	// 删除指定位置的元素,并返回移除的那个数
	public E remove(int index) {
		E result = (E) elementData[index];

		int numMov = size-index-1;
		if(numMov >0){
			System.arraycopy(elementData, index+1, elementData, index, numMov);
		}

		elementData[--size] = null;//let gc work
		return result;
	}

	// 返回列表元素的个数
	public int size() {
		return size;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for (int i = 1; i < size; i++) {
				result += "," + elementData[i];
			}

			return result + "]";
		}
	}

	// 检查添加元素时,创建一个更大的数组
	public void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length << 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}

			// Arrays.copyof：将原数组elementDate,考到其副本中，副本长度为newCapacity
			elementData = Arrays.copyOf(elementData, newCapacity);
		}

	}
	
	public Iterator<E> iterator(){
		return new MyListIterator(this);
	}
	
	private class MyListIterator implements Iterator<E>{
		private int position;
		private MyArrayList<E> list;
		private MyListIterator(MyArrayList<E>  list){
			this.list = list;
			position = 0;
		}
		@Override
		public boolean hasNext() {
			return position<size;
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E result = list.get(position);
			position++;
			return result ;
		}

		@Override
		public void remove() {
			
		}
		
	}

}
