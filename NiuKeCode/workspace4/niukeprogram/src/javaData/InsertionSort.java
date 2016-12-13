package javaData;

public class InsertionSort {

	public static void insertSort(long[] arr) {
		// i,记录需要插入的元素的位置
		for (int i = 1; i < arr.length; i++) {
			long temp = arr[i];// 将需要进行插入操作的数据保存到临时变量中
			int j = i;
			
			for (; j >0 && arr[j-1] > temp; j--) {
				arr[j] = arr[j - 1];// 将所有大于待插入的数向后移动一位
			}
			arr[j] = temp;// 将待插入的元素放到空位中
		}

	}
}
