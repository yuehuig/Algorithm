package 树;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 
 * @author yuehuig
 *
 */
public class _110_平衡二叉树 {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return subIsBalanced(root);
    }
	
	public boolean subIsBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int l = depth(root.left);
		int r = depth(root.right);
		return Math.abs(l - r) <= 1 && subIsBalanced(root.left) && subIsBalanced(root.right);
	}
	
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = depth(root.left);
		int r = depth(root.right);
		return Math.max(l, r) + 1;
	}
}
