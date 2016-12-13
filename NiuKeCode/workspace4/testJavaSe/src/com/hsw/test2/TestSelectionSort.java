package com.hsw.test2;

public class TestSelectionSort {
	
	public static void main(String[] args) {
		
		int[] a={1,123,12,28,183,156};
		selectionSort(a);
		
		for(int i=0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	}
	
	public static void selectionSort(int[] a){
		
		for(int i=0; i<a.length; i++){
			int smallist = i;
			
			for(int j=i+1;j<a.length;j++){
				if(a[j] < a[smallist]){
					smallist = j;
				}
			}
			
			swap(a,i,smallist);//swap smallest to front
		}
	}

	private static void swap(int[] a, int i, int smallist) {
		int temp = a[i];
		a[i]= a[smallist];
		a[smallist] = temp;
	}

}
