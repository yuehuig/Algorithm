package 动态规划;

/**
 * ◼最长公共子串(Longest Common Substring) 子串是连续的子序列
 * ◼ 求两个字符串的最长公共子串长度
 * ABCBA 和 BABCA 的最长公共子串是 ABC，长度为3
 *
 */
public class 最长公共子串 {
    /**
     * 思路
     *
     * ◼假设 2 个字符串分别是 str1、str2
     * i ∈ [1, str1.length]
     * j ∈ [1, str2.length]
     *
     * ◼假设 dp(i, j) 是以 str1[i – 1]、str2[j – 1] 结尾的最长公共子串长度 dp(i, 0)、dp(0, j) 初始值均为 0
     * 如果 str1[i – 1] = str2[j – 1]，那么 dp(i, j) = dp(i – 1, j – 1) + 1
     * 如果 str1[i – 1] ≠ str2[j – 1]，那么 dp(i, j) = 0
     * ◼最长公共子串的长度是所有 dp(i, j) 中的最大值 max { dp(i, j) }
     *
     * @param str1
     * @param str2
     * @return
     */
    public int lcs(String str1, String str2) {
        if (str1 == null || str1.length() == 0) return 0;
        if (str2 == null || str2.length() == 0) return 0;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        int max = 0;
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] != arr2[j - 1]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
