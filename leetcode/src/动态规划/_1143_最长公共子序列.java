package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 */
public class _1143_最长公共子序列 {

    /**
     * 3 动态规划 优化为一维数组
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence4(String text1, String text2) {
        if (text1 == null || text1.length() == 0) return 0;
        if (text2 == null || text2.length() == 0) return 0;
        int[] dp = new int[text2.length() + 1];
        char[] charArr1 = text1.toCharArray();
        char[] charArr2 = text2.toCharArray();

        for (int i = 1; i <= charArr1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= charArr2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (charArr1[i - 1] != charArr2[j - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                } else {
                    dp[j] = leftTop + 1;
                }
            }
        }
        return dp[charArr2.length];
    }

    /**
     * 3 动态规划 二维数组优化为滚动数组 即2行二维数组
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence3(String text1, String text2) {
        if (text1 == null || text1.length() == 0) return 0;
        if (text2 == null || text2.length() == 0) return 0;
        int[][] dp = new int[2][text2.length() + 1];
        char[] charArr1 = text1.toCharArray();
        char[] charArr2 = text2.toCharArray();

        for (int i = 1; i <= charArr1.length; i++) {
            int row = i & 1;
            int preRow = (i - 1) & 1;
//            int preRow = row ^ 1;
            for (int j = 1; j <= charArr2.length; j++) {
                if (charArr1[i - 1] != charArr2[j - 1]) {
                    dp[row][j] = Math.max(dp[preRow][j], dp[row][j - 1]);
                } else {
                    dp[row][j] = dp[preRow][j - 1] + 1;
                }
            }
        }
        return dp[charArr1.length & 1][charArr2.length];
    }

    /**
     * 2 非递归实现
     * LCS
     * 假设 2 个序列分别是 nums1、nums2
     * i ∈ [1, nums1.length]
     * j ∈ [1, nums2.length]
     *
     * 假设 dp(i, j) 是【nums1 前 i 个元素】与【nums2 前 j 个元素】的最长公共子序列长度
     * dp(i, 0)、dp(0, j) 初始值均为 0
     * 如果 nums1[i – 1] = nums2[j – 1]，那么 dp(i, j) = dp(i – 1, j – 1) + 1
     * 如果 nums1[i – 1] ≠ nums2[j – 1]，那么 dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
     */

    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text1.length() == 0) return 0;
        if (text2 == null || text2.length() == 0) return 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] charArr1 = text1.toCharArray();
        char[] charArr2 = text2.toCharArray();

        for (int i = 1; i <= charArr1.length; i++) {
            for (int j = 1; j <= charArr2.length; j++) {
                if (charArr1[i - 1] != charArr2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[charArr1.length][charArr2.length];
    }

    /**
     * 1 递归实现
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text1.length() == 0) return 0;
        if (text2 == null || text2.length() == 0) return 0;
        char[] charArr1 = text1.toCharArray();
        char[] charArr2 = text2.toCharArray();
        return lcs1(charArr1, charArr1.length, charArr2, charArr2.length);
    }

    private int lcs1(char[] charArr1, int i, char[] charArr2, int j) {
        if (i == 0 || j == 0) return 0;
        if (charArr1[i - 1] != charArr2[j - 1]) {
            return Math.max(lcs1(charArr1, i - 1, charArr2, j),
                    lcs1(charArr1, i, charArr2, j - 1));
        }
        return lcs1(charArr1, i - 1, charArr2, j - 1) + 1;
    }
}
