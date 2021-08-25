package 树;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author yuehuig
 *
 */
public class _105_从前序与中序遍历序列构造二叉树 {

	// 解法2
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
        return buildTreeSub2(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }
	
	public TreeNode buildTreeSub2(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
		if (p_start == p_end) {
			return null;
		}
		int root_val = preorder[p_start];
		TreeNode root = new TreeNode(root_val);
		
		int i_root_index = map.get(root.val);

		int left_num = i_root_index - i_start;
		root.left = buildTreeSub2(preorder, p_start + 1, p_start + left_num + 1, inorder, i_start, i_root_index, map);
		root.right = buildTreeSub2(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end, map);
		return root;
	}
	
	// 解法1
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeSub(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
	
	public TreeNode buildTreeSub(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
		if (p_start == p_end) {
			return null;
		}
		int root_val = preorder[p_start];
		TreeNode root = new TreeNode(root_val);
		
		int i_root_index = 0;
		for (int i = i_start; i < i_end; i++) {
			if (inorder[i] == root_val) {
				i_root_index = i;
				break;
			}
		}
		
		int left_num = i_root_index - i_start;
		root.left = buildTreeSub(preorder, p_start + 1, p_start + left_num + 1, inorder, i_start, i_root_index);
		root.right = buildTreeSub(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end);
		return root;
	}
}
