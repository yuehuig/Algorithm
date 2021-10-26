package 树;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        pre_travel(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode preNode = list.get(i - 1);
            preNode.left = null;
            preNode.right = list.get(i);
        }

    }

    public void pre_travel(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        pre_travel(node.left, list);
        pre_travel(node.right, list);
    }
}
