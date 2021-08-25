package 排序;

public class 归并排序 {
	public static void mergeSort(Integer[] array) {
		sort(array, 0, array.length);
	}

	public static void sort(Integer[] array, Integer begin, Integer end) {
		if (end - begin < 2) {
			return;
		}
		Integer mid = begin + ((end - begin) >> 1);
		// 先排序后合并
		sort(array, begin, mid);
		sort(array, mid, end);
		merge(array, begin, mid, end);
	}

	private static void merge(Integer[] array, Integer begin, Integer mid, Integer end) {
		// 左侧
		Integer li = 0, le = mid - begin;
		// 右侧  都是左闭右开区间
		Integer ri = mid, re = end;
		Integer ai = begin;
		// 新开辟一个左侧长度的数组 存放左侧的数组数据 然后想原数组插入
		Integer[] tempArr = new Integer[le];
		for (int i = li; i < le; i++) {
			tempArr[i] = array[i + begin];
		}
		while (li < le) {
			// 不写成(tempArr[li] < array[ri])   可以保持稳定性
			// 注意越界
			if ((ri < re) && (array[ri] < tempArr[li])) {
				array[ai++] = array[ri++];
			} else {
				array[ai++] = tempArr[li++];
			}
		}
	}

	/// =========
	public static void mergeSort1(Integer[] array) {
		if (array.length <= 1) {
			return;
		}
		sort1(array, 0, array.length);
	}

	public static void sort1(Integer[] array, Integer begin, Integer end) {
		if (end - begin < 2) {
			return;
		}
		Integer mid = begin + ((end - begin) >> 1);
		sort1(array, begin, mid);
		sort1(array, mid, end);
		merge1(array, begin, mid, end);
	}

	public static void merge1(Integer[] array, Integer begin, Integer mid, Integer end) {
		Integer li = 0, le = mid - begin;
		Integer ri = mid, re = end;
		Integer ai = begin;

		Integer[] tempArr = new Integer[le];
		for (int i = li; i < le; i++) {
			tempArr[i] = array[i + ai];
		}

		while (li < le) {
			if ((ri < re) && (array[ri] < tempArr[li])) {
				array[ai++] = array[ri++];
			} else {
				array[ai++] = tempArr[li++];
			}
		}
	}
}
