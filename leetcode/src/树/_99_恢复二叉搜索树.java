package 树;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_恢复二叉搜索树 {

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prevNode = null;

    private void findNode(TreeNode node) {
        if (prevNode != null && prevNode.val > node.val) {
            secondNode = node;
            if (firstNode == null) {
                // 切记 取的是prev
                firstNode = prevNode;
            } else {
                return;
            }
        }
        prevNode = node;
    }

    /**
     * 1 中序遍历查找逆序
     * 1）如果交换位置的两个 相邻的话 有一个逆序对  大的为first 小的为second
     * 2）如果交换位置的两个不相邻，则有两个逆序对  第一个逆序对 大的为first  第二个小的为second
     * @param root
     */
    public void recoverTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root);
        // 找完之后 记得互换值
        if (firstNode != null && secondNode != null) {
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        findNode(root);
        inOrder(root.right);
    }
}
