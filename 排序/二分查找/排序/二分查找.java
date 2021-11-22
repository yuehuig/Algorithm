package 排序;

public class 二分查找 {

	public static void main(String[] args) {
		int[] m = {2, 23,  33, 35, 232, 323, 4235, 23123};
//		int result = bSearch(m, 8, 34);
//		int result = bRecursionSearch(m, 8, 4235);
				int result = bSearch1(m, 8, 23123);
		System.out.println(result);
	}
	
	public static int bSearch(int[] a, int n, int value) {
		int low = 0;
		int high = n-1;
		while (low <= high) {
//			int mid = (low + high) / 2;
//			int mid = low + (high - low) / 2;
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	// 递归写法
	public static int bRecursionSearch(int[] a, int n, int value) {
		return bRecursionSubSearch(a, 0, n - 1, value);
	}
	
	public static int bRecursionSubSearch(int[] a, int low, int high, int value) {
		if (low > high) {
			return -1;
		}
		int mid = low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return bRecursionSubSearch(a, mid + 1, high, value);
		} else {
			return bRecursionSubSearch(a, low, mid - 1, value);
		}
	}

	public static int bSearch1(int[] a, int n, int value) {
		int begin = 0, end = n - 1;
		while (begin <= end) {
			int mid = begin + ((end - begin) >> 1);
			if (value == a[mid]) {
				return mid;
			} else if (value > a[mid]) {
				begin = mid + 1;
			} else  {
				end = mid - 1;
			}
		}
		return -1;
	}
}
