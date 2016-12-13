package javaData;

public class SelectionSort {
	
	public static void selectionSort(long[] arr){
		int k=0;
		long temp = 0;
		for(int i=0; i<arr.length-1; i++){
			k = i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[j] < arr[k]){
					k = j;
				}
			}
			
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
	}
}
