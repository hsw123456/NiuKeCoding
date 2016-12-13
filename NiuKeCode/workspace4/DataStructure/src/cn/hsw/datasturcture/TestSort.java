package cn.hsw.datasturcture;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSort {
	
	public static void main(String[] args) {
		int[] a = {8,5,9,2,3};
		int[] insertsort = insertSort(a) ;
		output(a);
		
	}
	
	public static int[] insertSort(int[] arr){
		for(int p =1; p<arr.length;p++){
			int temp = arr[p];
			int j = p;
			for(; j>0 && (temp<arr[j-1]) ;j--){
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
			
		}
		
		return arr;
		
	}
	
	public static void output(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
	}


}
