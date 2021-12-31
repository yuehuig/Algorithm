package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_二叉树的最小深度 {

    /**
     * 2 层序
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return height;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            height++;
        }
        return height;
    }

    /**
     * 1 递归
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Integer min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, minDepth1(root.left));
        }

        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }

        return min + 1;
    }
}
