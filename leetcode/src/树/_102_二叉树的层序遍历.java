package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 链表.ListNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * @author yuehuig
 *
 */
public class _102_二叉树的层序遍历 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			Integer levelSize = queue.size();
			List<Integer> tempList = new ArrayList<Integer>();
			while (levelSize > 0) {
				TreeNode node = queue.poll();
				tempList.add(node.val);

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
			list.add(tempList);
		}
		return list;
	}
}
