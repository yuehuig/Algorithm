package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 奇数行、偶数列的时候有问题
            if (top > bottom || left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
