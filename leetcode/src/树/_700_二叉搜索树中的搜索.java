package 树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        if (root.val == val) {
            return root;
        }
        return searchBST(root.val > val ? root.left : root.right, val);
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        var curTree = root;
        while (true) {
            if (curTree == null) {
                return null;
            }
            if (curTree.val == val) {
                return curTree;
            } else if (curTree.val < val) {
                curTree = curTree.right;
            } else {
                curTree = curTree.left;
            }
        }
    }
}
