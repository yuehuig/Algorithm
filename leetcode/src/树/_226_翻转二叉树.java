package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转一棵二叉树。
 * 
 * @author yuehuig
 *
 */
public class _226_翻转二叉树 {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		TreeNode lefTreeNode = invertTree(root.left);
		TreeNode righTreeNode = invertTree(root.right);
		root.left = righTreeNode;
		root.right = lefTreeNode;
		return root;
    }
	
	// 解法2
	public TreeNode invertTree1(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		TreeNode tempNode = root.right;
		root.right = root.left;
		root.left = tempNode;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
    }
	
	// 迭代
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			TreeNode tempNode = queue.poll();
			TreeNode rNode = tempNode.right;
			tempNode.right = tempNode.left;
			tempNode.left = rNode;
			
			if (tempNode.left != null) {
				queue.offer(tempNode.left);
			}
			
			if (tempNode.right != null) {
				queue.offer(tempNode.right);
			}
		}
		return root;
	}
}
