package 树;

import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 
 * @author yuehuig
 *
 */
public class _543_二叉树的直径 {

	int maxL = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxDepth(root);
		return maxL;
	}

	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxDL = maxDepth(root.left);
		int maxDR = maxDepth(root.right);
		int curL = maxDL + maxDR;
		maxL = Math.max(maxL, curL);
		return Math.max(maxDL, maxDR) + 1;
	}

}
