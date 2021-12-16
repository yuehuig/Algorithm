package 数组;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 */
public class _面试题_16_16_部分排序 {

    /**
     * 定义数组
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        int length = array.length;
        int[] res = new int[] {-1, -1};
        if (array == null || length <= 1) {
            return res;
        }

        // 记录最大值
        int max = array[0];
        // 从左到右遍历 查找逆序的最右位置
        for (int i = 0; i < length; i++) {
            if (array[i] >= max) { // 顺序则持续查找最大值
                max = array[i];
            } else { // 此处必然是逆序
                res[1] = i;
            }
        }

        // 没找到逆序
        if (res[1] == -1) {
            return res;
        }

        /// 记录最小值
        int min = array[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] <= min) { // 顺序则持续查找最大值
                min = array[i];
            } else { // 此处必然是逆序
                res[0] = i;
            }
        }
        return res;
    }

    /**
     * 2 定义变量
     * @param array
     * @return
     */
    public int[] subSort1(int[] array) {
        int length = array.length;
        if (array == null || length <= 1) {
            return new int[] {-1, -1};
        }

        // 记录最大值
        int max = array[0];
        // 记录最右的那个逆序的位置
        int r = -1;

        // 从左到右遍历 查找逆序的最右位置
        for (int i = 0; i < length; i++) {
            if (array[i] >= max) { // 顺序则持续查找最大值
                max = array[i];
            } else { // 此处必然是逆序
                r = i;
            }
        }

        // 没找到逆序
        if (r == -1) {
            return new int[] {-1, -1};
        }

        /// 记录最小值
        int min = array[length - 1];
        // 从右到左遍历 查找逆序的最左位置
        int l = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] <= min) { // 顺序则持续查找最大值
                min = array[i];
            } else { // 此处必然是逆序
                l = i;
            }
        }
        return new int[] {l, r};
    }
}
