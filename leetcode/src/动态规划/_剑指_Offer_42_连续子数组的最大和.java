package 动态规划;

/**
 * 最大连续子序列和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class _剑指_Offer_42_连续子数组的最大和 {

    /**
     * 优化为1个变量
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

    /**
     * 2 优惠dp数组为2个变量   空间复杂度降为O(1)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int pre = nums[0];
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (pre + nums[i] < nums[i]) {
                cur = nums[i];
            } else {
                cur = pre + nums[i];
            }
            maxSum = Math.max(cur, maxSum);
            pre = cur;
        }
        return maxSum;
    }

    /**
     * 3 dp数组
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] < nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }
}
