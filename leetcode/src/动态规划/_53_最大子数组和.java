package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class _53_最大子数组和 {

    /**
     * 5 动态规划优化  数组优化为变量
     * @param nums
     * @return
     */
    public int maxSubArray5(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            curSum = Math.max(curSum + nums[i], nums[i]);
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum = curSum + nums[i];
            }
            max = Math.max(curSum, max);
        }
        return max;
    }

    /**
     * 4 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int max = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prev = dp[i - 1];
            if (prev < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 3 分治
     *
     * 将序列均匀地分割成 2 个子序列
     * [begin , end) = [begin , mid) + [mid , end)，
     * mid = (begin + end) >> 1
     *
     * ◼假设 [begin , end) 的最大连续子序列和是 S[i , j) ，那么它有 3 种可能
     *
     * 1 [i , j) 存在于 [begin , mid) 中，同时 S[i , j) 也是 [begin , mid) 的最大连续子序列和
     * 2 [i , j) 存在于 [mid , end) 中，同时 S[i , j) 也是 [mid , end) 的最大连续子序列和
     * 3 [i , j) 一部分存在于 [begin , mid) 中，另一部分存在于 [mid , end) 中
     *
     * ✓[i , j) = [i , mid) + [mid , j)
     * ✓S[i , mid) = max { S[k , mid) }，begin ≤ k < mid
     * ✓S[mid , j) = max { S[mid , k) }，mid < k ≤ end
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArrayDivide(nums, 0, nums.length);
    }

    private int maxSubArrayDivide(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = begin + ((end - begin) >> 1);
        int leftMax = nums[mid - 1];
        int leftSum = leftMax;

        for (int i = mid - 2; i >= 0; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }

        int rightMax = nums[mid];
        int rightSum = rightMax;

        for (int i = mid + 1; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        return Math.max(leftMax + rightMax,
                Math.max(maxSubArrayDivide(nums, begin, mid), maxSubArrayDivide(nums, mid, end)));
    }

    /**
     * 2 暴力算法优化
     *
     * 优化sum 连续子序列  下一项sum 等于前一项 + nums[end] 没必要从头加
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            // 注意end = begin
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    /**
     * 1 暴力算法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            // 注意end = begin
            for (int end = begin; end < nums.length; end++) {
                int sum = 0;
                // 注意 i <= end
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}
