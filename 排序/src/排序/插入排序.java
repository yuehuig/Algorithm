package 排序;

public class 插入排序 {
	/////////////  交换方式   /////////////  
	// 升序
	public static void insertionSort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					Integer temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	// 降序
	public static void insertionSort1(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] >= array[j - 1]) {
					Integer temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
   /////////////  挪动方式   /////////////
	public static void insertionSort2(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			Integer curValue = array[i];
			Integer index = i - 1;
			for (int j = i; j > 0; j--) {
				if (curValue < array[j-1]) {
					array[j] = array[j-1];
					index = j - 1;
				}
			}
			array[index] = curValue;
		}
	}
	
	// 二分查找位置 直接插入？
}
