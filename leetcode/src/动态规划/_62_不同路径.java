package 动态规划;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * https://leetcode-cn.com/problems/unique-paths

 */
public class _62_不同路径 {
    /// 第一行和第一列都是直达 初始化为1
    /// dp[m][n] 到达dp[m][n-1] 和 dp[m-1][n]的路径和
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int row = 1; row < m; row++) {
            dp[row][0] = 1;
        }

        for (int col = 1; col < n; col++) {
            dp[0][col] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
