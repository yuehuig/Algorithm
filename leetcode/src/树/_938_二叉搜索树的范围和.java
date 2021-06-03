package 树;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 
 * @author yuehuig
 *
 */
public class _938_二叉搜索树的范围和 {
	
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		calc(root, low, high, sum);
		return sum;
    }
	
	public void calc(TreeNode root, int low, int high, int sum) {
		if (low <= root.val && root.val <= high) {
			sum += root.val;
		}
		calc(root.left, low, high, sum);
		calc(root.right, low, high, sum);
    }
}
