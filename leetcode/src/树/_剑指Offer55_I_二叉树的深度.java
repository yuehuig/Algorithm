package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * 
 * @author yuehuig
 *
 */
public class _剑指Offer55_I_二叉树的深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    // 层序
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue =  new LinkedList<TreeNode>();
        queue.offer(root);
        int l = 0;
        while (queue.isEmpty() == false) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                levelSize--;
            }
            l++;
        }
        return l;
    }
	
}
