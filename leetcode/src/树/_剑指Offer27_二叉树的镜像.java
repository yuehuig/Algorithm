package 树;

import com.sun.tools.javac.tree.JCTree.LetExpr;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 
 * @author yuehuig
 *
 */
public class _剑指Offer27_二叉树的镜像 {
	
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		reversed(root);
		return root;
    }
	
	public void reversed(TreeNode node) {
		if (node == null) {
			return;
		}
		reversed(node.left);
		reversed(node.right);
		TreeNode tempNode = node.left; 
		node.left = node.right;
		node.right = tempNode;
	}
}
