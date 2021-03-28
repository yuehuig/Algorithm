package 排序;

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
	
	public static void swap(Integer[] array, Integer a1, Integer a2) {
		Integer temp = array[a1];
		array[a1] = array[a2];
		array[a2] = temp;
	}
}
