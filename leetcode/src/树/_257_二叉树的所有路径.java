package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * @author yuehuig
 *
 */
public class _257_二叉树的所有路径 {

	/// DFS
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (root == null) {
			return paths;
		}
		buildPaths(root, "", paths);
		return paths;
    }
	
	public void buildPaths(TreeNode node, String nPath, List<String> paths) {
		if (node == null) {
			return;
		}
		StringBuilder sb = new StringBuilder(nPath);
		sb.append(Integer.toString(node.val));
		if (node.left == null && node.right == null) {
			paths.add(sb.toString());
		} else {
			sb.append("->");
			buildPaths(node.left, sb.toString(), paths);
			buildPaths(node.right, sb.toString(), paths);
		}
	}
}
