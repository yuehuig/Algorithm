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
		冒泡排序.bubbleSort(array);
//		选择排序.selectionSort(array);
//		选择排序.selectionSort1(array);
//		插入排序.insertionSort2(array);
//		归并排序.mergeSort(array);
//		快速排序.quickSort(array);
//		希尔排序.shellSort(array);
//		计数排序.countSort2(array);
		System.out.println("\n");
		System.out.println(Arrays.toString(array));
	}

}
