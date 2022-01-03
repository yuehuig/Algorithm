package 数组;

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class _628_三个数的最大乘积 {

    /**
     * 2
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3) {
            return 0;
        }
        // 先排序
        Arrays.sort(nums);
        // 分3种情况
        // 1 所有都为负数  则 最右边（最大的3个数相乘 值最大）
        // 2 所有数都为正数 则 最右边 （最大的3个数相乘 值最大）
        // 3 有负有正  1）只有一个负数  则 最右边 （最大的3个数相乘 值最大）
        //            2）有2个以上负数  则 最小的两个负数 nums[0] * nums[1] * nums[length - 1]
        // 综上 只有2种方式 nums[0] * nums[1] * nums[length - 1] 和
        //  nums[length-3] * nums[length - 2] * nums[length - 1]
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length-3] * nums[length - 2] * nums[length - 1]);
    }

    /**
     * 2 利用 上边方法 遍历 求出相关的 5个数 2个最小值和3个最大值
     * @param nums
     * @return
     */
    public int maximumProduct1(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3) {
            return 0;
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        // 计算出相关的5个值
        for (int num : nums) {
            // min1 < min2
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            // max1 > max2 > max3
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
