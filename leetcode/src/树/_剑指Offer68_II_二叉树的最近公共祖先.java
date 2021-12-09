package 树;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先
 * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * @author yuehuig
 *
 */
public class _剑指Offer68_II_二叉树的最近公共祖先 {

	// 第一种
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
        	return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        
        if (leftNode == null && rightNode == null) {
        	return null;
        }
        
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        return root;
    }
	
	
	// 第二种
	TreeNode fNode = null;
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
        	return root;
        }
        travel(root, p, q);
        return fNode;
    }
	
	public boolean travel(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null) {
			return false;
		}
		boolean lson = travel(node.left, p, q);
		boolean rson = travel(node.right, p, q);
		if ((lson && rson) || ((lson || rson) && ((node.val == p.val) || (node.val == q.val)))) {
			fNode = node;
		}
		return lson || rson || (node.val == p.val || node.val == q.val);
	}

	// 第三种
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> list1 = getPath(root, p);
		List<TreeNode> list2 = getPath(root, q);
		TreeNode node = null;
		for (int i = 0; i < list1.size() && i < list2.size(); i++) {
			if (list1.get(i) == list2.get(i)) {
				node = list1.get(i);
			} else {
				break;
			}
		}
		return node;
	}

	private List<TreeNode> getPath(TreeNode root, TreeNode targetNode) {
		List<TreeNode> list = new ArrayList();
		TreeNode curNode = root;
		while (curNode != targetNode) {
			list.add(curNode);
			if (curNode.val > targetNode.val) {
				curNode = curNode.left;
			} else {
				curNode = curNode.right;
			}
		}
		list.add(curNode);
		return list;
	}

	// 第四种
	public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while (true) {
			if (p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else if (p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else {
				break;
			}
		}
		return ancestor;
	}
}
