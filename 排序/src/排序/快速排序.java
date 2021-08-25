package 排序;

import java.util.Random;

public class 快速排序 {
	public static void quickSort(Integer[] array) {
		sort(array, 0, array.length);
	}
	
	public static void sort(Integer[] array, Integer begin, Integer end) {
		if ((end - begin) < 2) {
			return;
		}
		
		// 确定轴点位置 O(n)
		Integer mid = provitIndex(array, begin, end);
		sort(array, begin, mid);
		sort(array, mid+1, end); // T(n - 1)
	}
	
	public static int provitIndex(Integer[] array, Integer begin, Integer end) {
		// 随机选择一个位置和begin 交换 begin为轴
		swap(array, begin, begin + (int)(Math.random() * (end - begin))); 
		Integer provit = array[begin];
		end--;
		while (begin < end) {
			while (begin < end) {
				if (provit < array[end]) { // 右边元素 > 轴点元素
					end--;
				} else { // 右边元素 <= 轴点元素
					array[begin++] = array[end]; 
					break;
				}
			}
			
			while (begin < end) {
				if (array[begin] < provit) { // 左边元素 < 轴点元素
					begin++;
				} else { // 左边元素 >= 轴点元素
					array[end--] = array[begin];
					break;
				}
			}
		}
		// 将轴点元素放入最终位置
		array[begin] = provit;
		// 返回轴点元素位置
		return begin;
	}
	
	public static void swap(Integer[] array, Integer a1, Integer a2) {
		Integer temp = array[a1];
		array[a1] = array[a2];
		array[a2] = temp;
	}
	
	// ====================
	public static void quickSort1(Integer[] array) {
		if (array.length <= 1) {
			return;
		}
		sort1(array, 0, array.length);
	}

	public static void sort1(Integer[] array, Integer begin, Integer end) {
		if (end - begin < 2) {
			return;
		}
		int provitIdx = provitIndex1(array, begin, end);
		sort1(array, begin, provitIdx);
		sort1(array, provitIdx + 1, end);
	}

	public static int provitIndex1(Integer[] array, Integer begin, Integer end) {
		int provitIdx = begin + (int)(Math.random() * (end - begin));
		swap1(array, begin, provitIdx);
		end--;
		Integer provit = array[begin];

		while (begin < end) {
			while (begin < end) {
				if (provit < array[end]) {
					end--;
				} else {
					array[begin++] = array[end];
					break;
				}
			}

			while (begin < end) {
				if (array[begin] < provit) {
					begin++;
				} else {
					array[end--] = array[begin];
					break;
				}
			}
		}
		array[begin] = provit;
		return begin;
	}

	public static void swap1(Integer[] array, Integer m, Integer n) {
		Integer temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
}
