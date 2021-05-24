package 树;

import java.util.ArrayList;
import java.util.Stack;

public class 二叉树前序遍历 {
	public static void preorderTraversal(TreeNode root) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		if (root == null) {
			return;
		}
		preorder(root, arrList);
	}
	
	private static void preorder(TreeNode node, ArrayList<Integer> arrList) {
		if (node == null) {
			return;
		}
		arrList.add(node.val);
		preorder(node.left, arrList);
		preorder(node.right, arrList);
	}
	
	// 非递归  ⚠️⚠️⚠️注意是栈先入 右子树 再入 左子树
	public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
		if (root == null) {
			return arrList;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (stack.isEmpty() == false) {
			TreeNode node = stack.pop();
			arrList.add(node.val);
            if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
        return arrList;
    }
}
