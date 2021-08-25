package 树;

import java.util.LinkedList;
import java.util.Queue;

import 链表.ListNode;

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
	
	// 广度优先搜索
	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int maxDepth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int levelSize = queue.size();
			while (levelSize > 0) {
				TreeNode tempNode = queue.poll();
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			
				levelSize--;
			}
			maxDepth++;
		}
		return maxDepth;
    }
}
