package 树;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class _剑指Offer54_二叉搜索树的第k大节点 {
    // 中序 倒序
    int res = -1, k = 0;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.right);
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }
        inorder(root.left);
    }
}
