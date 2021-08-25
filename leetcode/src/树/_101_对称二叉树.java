package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * @author yuehuig
 *
 */
public class _101_对称二叉树 {
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return check(root.left, root.right);
	}
	
	public boolean check(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (l == null || r == null) {
			return false;
		}
		return (l.val == r.val) && check(l.left, r.right) && check(l.right, r.left);
	}
	
	// 非递归
	public boolean isSymmetric1(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		while (queue.size() > 0) {
			TreeNode l = queue.poll();
			TreeNode r = queue.poll();
			if (l == null && r == null) {
				continue;
			} else if (l == null || r == null) {
				return false;
			} else if (l.val != r.val) {
				return false;
			} 
			
			queue.add(l.left);
			queue.add(r.right);
			
			queue.add(l.right);
			queue.add(r.left);
		}
		return true;
    }
}
