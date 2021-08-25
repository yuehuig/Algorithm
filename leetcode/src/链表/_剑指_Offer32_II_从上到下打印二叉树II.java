package 链表;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @author yuehuig
 *
 */
public class _剑指_Offer32_II_从上到下打印二叉树II {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (root == null) {
			return list;
		}
		travel(root, list);
		return list;
    }
	
	public void travel(TreeNode node, List<List<Integer>> list) {
		if (node == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		while (queue.isEmpty() == false) {
			int levelSize = queue.size();
			List<Integer> levelList = new LinkedList<Integer>();
			while (levelSize > 0) {
				TreeNode tempNode = queue.poll();
				levelList.add(tempNode.val);
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
				levelSize--;
			}
			list.add(levelList);
		}
	}
}
