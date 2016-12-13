package com.hsw.test2;

import java.util.Arrays;

/**
 * 测试归并排序：使用递归方式对给定数组分解成两个部分
 * 使用递归的需要考虑基本情况和递归情况：
 * 基本情况：递归的数组必要满足长度大于1
 * 
 *伪代码如下：
 *if(a.length>1){
 *	将数组分成两半
 *	对左半部分进行归并排序
 *	对有半部分进行归并排序
 *	合并左右两个部分
 *}
 * @author Administrator
 *
 */
public class TestMergeSort {
	
	public static void main(String[] args) {
		int[] a = {14,32,67,76,23,41,58,85};
		mergeSort(a);
		
		System.out.println(Arrays.toString(a));
	}
	
	public static void mergeSort(int[] a){
		if(a.length>1){
			System.out.println("sorting:" + Arrays.toString(a));
			
			int[] left = Arrays.copyOfRange(a, 0, a.length/2);
			int[] right = Arrays.copyOfRange(a, a.length/2, a.length);
			mergeSort(left);
			mergeSort(right);
			
			System.out.println("merging "+Arrays.toString(left)
					+"and "+Arrays.toString(right) );
			merge(a, left, right);
		}
		
	}
	
	public static void merge(int[]result, int[] left, int[] right){
			int i1=0;
			int i2=0;
		for(int i=0; i<result.length;i++){
			if((i1<left.length&&left[i1]<=right[i2])||i2>=right.length){
				result[i] = left[i1];
				i1++;
			}else{
				result[i]= right[i2];
				i2++;
			}
		}
	}
}
