package 排序;

public class 希尔排序 {
	public static void shellSort(Integer[] array) {
		if ((array == null) || array.length < 2) {
			return;
		}
		
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				for (int j = i-gap; j >= 0; j -= gap) {
					if (array[j] > array[j + gap]) {
						swap(array, j, j+gap);
					}
				}
				
			}
			/// 测试
            for (int m = 0; m < array.length; m++) {
                System.out.print(array[m] + " ");
            }
            System.out.println("");
            
		}
	}
	
	public static void swap(Integer[] array, Integer a1, Integer a2) {
		Integer temp = array[a1];
		array[a1] = array[a2];
		array[a2] = temp;
	}
}
