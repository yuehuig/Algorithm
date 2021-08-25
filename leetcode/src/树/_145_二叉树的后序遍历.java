package 树;

import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 给定一个二叉树，返回它的 后序 遍历。
 * 
 * @author yuehuig
 *
 */
public class _145_二叉树的后序遍历 {
	
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
}
