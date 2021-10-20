package 排序;

import java.util.Arrays;
import tools.Integers;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] array = Integers.random(12, 1, 100);
		Integer[] array = {55, 84, 66, 96, 10, 8, 10, 75, 48, 79, 14, 7};
		System.out.println(Arrays.toString(array));
		System.out.println("\n");
//		冒泡排序.bubbleSort(array);
//		选择排序.selectionSort(array);
//		选择排序.selectionSort1(array);
//		插入排序.insertionSort2(array);
//		归并排序.mergeSort(array);
		归并排序.mergeSort1(array);
//		快速排序.quickSort(array);
//		快速排序.quickSort1(array);
//		希尔排序.shellSort(array);
//		计数排序.countSort2(array);
		System.out.println("\n");
		System.out.println(Arrays.toString(array));

		System.out.println(sum1(100));
	}

	public static Integer sum(Integer n) {
		if (n <= 0) {
			return 0;
		}
		return n + sum(n - 1);
	}

	public static Integer sum1(Integer n) {
		int result = 0;
		for (int i = 0; i <= n; i++) {
			result += i;
		}
		return result;
	}

	public static int fib1(Integer n) {
		if (n < 2) {
			return 1;
		}
		return fib1(n - 1) + fib1(n-2);
	}
}
