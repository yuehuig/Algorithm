package 排序;

import java.util.Arrays;
import tools.Integers;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = Integers.random(10, 1, 500);
//		Integer[] array = {0, 1};
		System.out.println(Arrays.toString(array));
		System.out.println("\n");
//		冒泡排序.bubbleSort(array);
//		选择排序.selectionSort(array);
//		插入排序.insertionSort2(array);
//		归并排序.mergeSort(array);
		快速排序.quickSort(array);
		System.out.println("\n");
		System.out.println(Arrays.toString(array));
	}

}
