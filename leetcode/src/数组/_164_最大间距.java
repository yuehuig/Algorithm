package 数组;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * https://leetcode-cn.com/problems/maximum-gap/
 */
public class _164_最大间距 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 2) {
            return 0;
        }

        int minVal = Arrays.stream(nums).min().getAsInt(); // 最小值
        int maxVal = Arrays.stream(nums).max().getAsInt(); // 最大值

        // 桶区间大小因子
        int d = Math.max(1, (maxVal - minVal) / (n - 1));

        // 在目标数组中需要划分的 桶 的个数， +1是为了消除d取整前的小数部分带来的误差（注意运算顺序）
        int bucketSize = (maxVal - minVal) / d + 1;

        // 其实就是一个bucketSize个长度为2的一维数组，这个一维数组用来记录每个区间的的最大值和最小值
        // 0下标存的是最小值，1下标存的是最大值
        int[][] bucket = new int[bucketSize][2];

        // 给二维数组赋初始值为-1
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }

        for (int i = 0; i < n; i++) {
            // 判断当前元素属于哪个桶区间
            int idx = (nums[i] - minVal) / d;

            // 若区间为空，则此元素是第一次进来，则最大值和最小值都是它
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else { // 若区间存在其他元素，则开始下面比较
                // 当前元素与此桶区间的最小值比较，若比最小值还小，就把最小值替换成当前元素值
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                // 当前元素与此桶区间的最大值比较，若比最大值还大，就把最大值替换成当前元素值
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        // 经过上面的一系列操作，我们发现，这个二维数组居然出现了顺序结构
        // 现在进行最后一步

        int ret = 0;  // 目标值
        int prev = -1; // 上一个目标

        // 开始遍历每个桶列表
        for (int i = 0; i < bucketSize; i++) {
            // 判断当前桶区间是否为空，空则跳出
            if (bucket[i][0] == -1) {
                continue;
            }
            // 判断上一个下标是否为空，即是否第一次循环
            if (prev != -1) {
                /*
                 * 计算上一个桶区间的最大值，与当前桶区间的的最小值的差
                 * 然后与ret目标值比较，取最大值然后替换ret值
                 */
                ret = Math.max(bucket[i][0] - bucket[prev][1], ret);
            }
            prev = i; // 上一个下标自增
        }
        return ret;
    }
}
