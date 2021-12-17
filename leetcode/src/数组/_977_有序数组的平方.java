package 数组;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class _977_有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] arr = new int[n];
        int i = 0;
        int j = n - 1;
        int cur = j;
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                arr[cur--] = nums[j] * nums[j--];
            } else {
                arr[cur--] = nums[i] * nums[i++];
            }
        }

        return arr;
    }
}
