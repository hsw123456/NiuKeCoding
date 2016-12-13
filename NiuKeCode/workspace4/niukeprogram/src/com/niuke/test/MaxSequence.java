package com.niuke.test;

import java.util.Scanner;

public class MaxSequence {

	public static void main(String[] args) {
		int count = 0;
		long[] nums = null;
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			count = input.nextInt();
			nums = new long[count];
			for (int i = 0; i < count; i++) {
				nums[i] = input.nextLong();
			}

			System.out.println(maxsumSequence(count, nums));
		}

		long sum = maxsumSequence(count, nums);
		System.out.println(sum);
	}

	public static long maxsumSequence(int count, long[] nums) {
		long maxSum = nums[0];
		long thisSum = 0;
		
		for(int i=0; i<count; i++){
			if(nums[i] > maxSum)
				maxSum = nums[i];
		}
		for (int i = 0, j = 0; j < count; j++) {
			thisSum += nums[j];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			} else if (thisSum < 0) {
				i = j + 1;
				thisSum = 0;
			}
		}
		
		return maxSum;
	}
}
