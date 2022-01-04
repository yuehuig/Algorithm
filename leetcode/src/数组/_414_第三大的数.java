package 数组;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * https://leetcode-cn.com/problems/third-maximum-number/
 */
public class _414_第三大的数 {
    public int thirdMax(int[] nums) {
        // 最小值定为 Integer的最小值 会越界 所以定为Long型
        long m1 = Long.MIN_VALUE, m2 = m1, m3 = m1;
        for (int num: nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2 && num < m1) { // 排除相等的情况
                m3 = m2;
                m2 = num;
            } else if (num > m3 && num < m2) { // 排除相等的情况
                m3 = num;
            }
        }

        return m3 > Long.MIN_VALUE ? (int)m3 : (int)m1;
    }
}
