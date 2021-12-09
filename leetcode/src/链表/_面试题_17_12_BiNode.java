package 链表;
/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * https://leetcode-cn.com/problems/binode-lcci/
 */
public class _面试题_17_12_BiNode {
    TreeNode head = new TreeNode(-1);
    TreeNode preHead = null;
    public TreeNode convertBiNode(TreeNode root) {
        inorderTravel(root);
        return root;
    }

    public void inorderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravel(root.left);
        if (preHead == null) {
            head.right = root;
        } else {
            preHead.right = root;
            head.right = preHead;
        }
        preHead = root;
        root.left = null;
        inorderTravel(root.right);
    }
}
