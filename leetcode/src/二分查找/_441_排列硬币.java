package 二分查找;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * https://leetcode-cn.com/problems/arranging-coins
 */
public class _441_排列硬币 {

    /**
     * 2 二分查找  超出int
     * @param n
     * @return
     */
    public int arrangeCoins2(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            long cost = (mid * (mid + 1)) >> 1;
            if (n == cost) {
                return (int)mid;
            } else if (cost > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }

    /**
     * 1 暴力解法
     * @param n
     * @return
     */
    public int arrangeCoins1(int n) {
        if (n <= 1) {
            return n;
        }

        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n < i) {
                return i;
            }
        }
        return 0;
    }
}
