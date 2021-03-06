package cn.hsw.datasturcture;

public class QuickSort {
	
	private static final int CUTOFF = 10;
	
	public static void main(String[] args) {
		
		Integer[] a = new Integer[100000];
		for(int i=0; i<a.length; i++){
			a[i]= 100000-i;
		}
		
		long start = System.currentTimeMillis();
			insertionSort(a, 0, a.length);
			//QuickSort(a, 0, a.length-1);
			
			for(int i = 0; i<a.length; i++){
				System.out.println(a[i]);
			}
			
		long end = System.currentTimeMillis();
		System.out.println("Consume Time:" +(end-start));//421,//109,//4774, //37379
	}
	
	public static <AnyType extends Comparable<? super AnyType>> 
	void QuickSort(AnyType[] a, int low ,int high){
		
		if(low+CUTOFF >high)
			insertionSort(a,low,high);
		else {
			//sort low,middle,high
			int middle = (low +high)/2;
			if(a[middle].compareTo(a[low])<0){
				swapReference(a,middle,low);
			}
			
			if(a[high].compareTo(a[low])<0){
				swapReference(a,high,low);
			}
			if(a[high].compareTo(a[middle])<0){
				swapReference(a,high,middle);
			}
			//Place pivot at position high-1
			swapReference(a, middle, high-1);
			AnyType pivot  = a[high-1];
			
			//begin partitioning
			
			int i,j;
			for(i=low,j=high-1 ; ;){
				while(a[++i].compareTo(pivot) <0);
				while(pivot.compareTo(a[--j]) <0);
				if(i >=j)
					break;
				swapReference(a, i, j);
			}
			
			//Restore pivot
			swapReference(a, i, high-1);
			QuickSort(a, low, i-1);//Sort small elements
			QuickSort(a, i+1, high);//Sort large elements
			
			
		}
		
		
		
	}
	
	public static <AnyType extends Comparable<? super AnyType>> 
		void insertionSort(AnyType[] a, int low, int high){
		
		for(int p = 1;p<high; p++){
			AnyType temp = a[p];
			int j = p;
			
			for(; j>0 &&temp.compareTo(a[j-1])<0; j--){
				a[j] = a[j-1];
				a[j-1] = temp;
			}
		}
	}
	
	public static void swapReference(Object[] a,int i,int j){
		Object temp; 
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
		
}
