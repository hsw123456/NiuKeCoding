package cn.hsw.datasturcture;

public class MaxSum {

	public static void main(String[] args) {

		// int[] a= {-2,11,-4,13,-5,2};
		// int[] a= new int[6];
		int[] a = new int[] { -2, 11, -4, 13, -5, -2 };
		System.out.println(maxSum(a));
		System.out.println(maxSubSequenceSum(a));

	}

	public static int maxSum(int[] arr) {

		/*
		 * // 如果数组的所有元素都小于0则返回0 boolean flag = false; for (int i = 0; i <
		 * arr.length; i++) { if (arr[i] > 0) { flag = true; break; } }
		 * 
		 * if (!flag) { return 0; }
		 */

		// 如果有非负数的时候再计算子序列最大值
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++) {
					thisSum += arr[k];
				}
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}

		}

		return maxSum;
	}

	public static int maxSubSequenceSum(int[] a) {
		int maxSum = 0;

		for (int i = 0; i < a.length; i++) {

			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				
				thisSum += a[i];
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}

		return maxSum;
	}

}
