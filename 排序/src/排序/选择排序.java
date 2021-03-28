package 排序;

public class 选择排序 {
	public static void selectionSort(Integer[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			Integer maxIndex = i;
			for (int j = 0; j < i; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				Integer temp = array[i];
				array[i] = array[maxIndex];
				array[maxIndex] = temp;
			}
		}
	}
}
