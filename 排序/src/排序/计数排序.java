package 排序;

public class 计数排序 {
	
	public static void countSort(Integer[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		
		Integer max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		int[] counts = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			counts[array[i]]++;
		}
		
		int idx = 0;
//		for (int i = 0; i < counts.length; i++) {
//			while (counts[i] > 0) {
//				array[idx] = i;
//				idx += 1;
//				counts[i]--;
//			}
//		}
		for (int i = 0; i < counts.length; i++) {
			while (counts[i]-- > 0) {
				array[idx++] = i;
			}
		}
	}
	
	public static void countSort1(Integer[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		Integer min = array[0];
		Integer max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		
		if (min == max) {
			return;
		}
		
		int[] counts = new int[max - min + 1];
		for (int i = 0; i < array.length; i++) {
			counts[array[i] - min]++;
		}
		
		int idx = 0;
		for (int i = 0; i < counts.length; i++) {
			while (counts[i] > 0) {
				array[idx] = i + min;
				idx += 1;
				counts[i]--;
			}
		}
	}
	
	public static void countSort2(Integer[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		Integer min = array[0];
		Integer max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		
		if (min == max) {
			return;
		}
		
		int[] counts = new int[max - min + 1];
		for (int i = 0; i < array.length; i++) {
			// array[i] - min -> counts数组中的索引
			counts[array[i] - min]++;
		}
		
		// 从第一项开始次数等于前几次的和加上当前的次数
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
		
		// 倒序遍历原始数组，从统计数组中找到正确位置
		int[] sortArr = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
//			sortArr[] = array[i];  从原数组取出一个元素
			
			// array[i] - min -> counts数组中的索引
			// counts[array[i] - min] -> 取出该索引对应 小于等于该元素出现的次数 等于是排了多少个元素   值是累加的之前
			
			counts[array[i] - min] -= 1;
			sortArr[counts[array[i] - min]] = array[i];
			
//			sortArr[--counts[array[i] - min]] = array[i];
		}
		
		for (int i = 0; i < sortArr.length; i++) {
			array[i] =  sortArr[i];
		}
	}
}
