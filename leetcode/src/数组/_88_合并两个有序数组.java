package 数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 */
public class _88_合并两个有序数组 {


    /**
     * 2 反向填充
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0 || n == 0) return;
        int curM = m - 1;
        int curN = n - 1;
        int cur = m + n - 1;
        while (curN >= 0) {
            if (curM >= 0 && nums1[curM] > nums2[curN]) {
                nums1[cur--] = nums1[curM--];
            } else {
                nums1[cur--] = nums2[curN--];
            }
        }
    }

    /**
     * 1 新增数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0 || n == 0) return;
        int[] result = new int[m+n];
        int curM = 0;
        int curN = 0;
        int cur = 0;
        while (curM < m && curN < n) {
            if (nums1[curM] <= nums2[curN]) {
                result[cur++] = nums1[curM++];
            } else {
                result[cur++] = nums2[curN++];
            }
        }

        while (curM < m) {
            result[cur++] = nums1[curM++];
        }

        while (curN < n) {
            result[cur++] = nums2[curN++];
        }
        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }
}
