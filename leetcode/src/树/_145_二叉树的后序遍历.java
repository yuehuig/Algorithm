package 树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 参考资料
 * https://www.cnblogs.com/kalton/p/13689985.html
 *
 * @author yuehuig
 */
public class _145_二叉树的后序遍历 {

	/**
	 * 1 递归后序
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        postT(root, res);
        return res;
    }
	
	public void postT(TreeNode root, List<Integer> res) {
		if (root == null) {
        	return;
        }
		postT(root.left, res);
		postT(root.right, res);
		res.add(root.val);
	}

	/**
	 * 2 迭代后序
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list= new ArrayList<>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		// 上一次访问的节点  如果前一个访问的节点和当前访问的节点的父节点是同一个
		TreeNode prev = null;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			// 栈顶节点是叶子节点或者上一次访问的节点是栈顶节点的子节点(代表已经访问过了 现在是返回回来的 需要弹出了 置为nil 是因为已经遍历过了 避免再次压入栈中)
			if ((node.right == null) || (node.right == prev)) {
				list.add(node.val);
				prev = node;
				// 这里node没有改变指向，所以需要指向null，否则会死循环
				// 置为nil 是因为已经遍历过了 避免再次压入栈中
				node = null;
			} else {
				// 既不是子节点且上一次访问的节点又不是栈顶节点的右子节点话，重新进栈   访问左子节点 -> 回来当前node 判断上次访问节点是否是右节点 或者 右节点为空 不是这两种情况则重新入栈 -> 访问由子节点
				stack.push(node);
				node = node.right;
			}
		}
		return list;
	}

	/**
	 * 3 迭代 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> list= new ArrayList<>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (stack.isEmpty() == false) {
			TreeNode node = stack.pop();
			list.add(node.val);
			// 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左    跟前序遍历相比，左右子节点 入栈顺序需调整
			if (node.left != null) {
				stack.push(node.left);
			}

			if (node.right != null) {
				stack.push(node.right);
			}
		}
		// 反转
		Collections.reverse(list);
		return list;
	}
}
