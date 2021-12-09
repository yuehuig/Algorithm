package 树;
import java.util.Queue;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 *
 * 计算给定二叉树的所有左叶子之和。
 */
public class _404_左叶子之和 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        travel(root);
        return sum;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if ((node.left.left == null) && (node.left.right == null)) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

        }
    }
}
