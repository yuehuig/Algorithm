package 树;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * @author yuehuig
 *
 */
public class _104_二叉树的最大深度 {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax) + 1;
    }
}
