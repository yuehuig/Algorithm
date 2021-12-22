package 树;

/**
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 *
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * 二叉搜索树（BST）中的所有节点都具备以下属性：
 * 左子树的值小于其父（根）节点的值。
 * 右子树的值大于其父（根）节点的值。
 *
 * 注意:
 * 子树必须包含其所有后代。
 *
 */
public class _333_最大BST子树 {

    /*最大BST树信息*/
    private static class Info {
        /*根节点*/
        public TreeNode root;
        /*节点总数*/
        public int size;
        /*最小值*/
        public int min;
        /*最大值*/
        public int max;

        public Info(TreeNode root, int size, int min, int max) {
            this.root = root;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    private Info getInfo(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 后序变量
        /*左子树的最大BST子树信息*/
        Info li = getInfo(root.left);
        /*右子树的最大BST子树信息*/
        Info ri = getInfo(root.right);

        /*
        有4种情况，以root为根节点的二叉树就是一棵BST，最大BST子树就是其本身
        ① li != null && ri != null
        && li.root == root.left && root.val > li.max
        && ri.root == root.right && root.val < ri.min

        ② li != null && ri == null
        && li.root == root.left && root.val > li.max

        ③ li == null && ri != null
        && ri.root == root.right && root.val < ri.min

        ④ li == null && ri == null
         */

        int leftBstSize = -1, rightBstSize = -1, max = root.val, min = root.val;

        if (li != null && ri != null &&
                li.root == root.left && root.val > li.max &&
                ri.root == root.right && root.val < ri.min) {
            leftBstSize = li.size;
            rightBstSize = ri.size;
            min = li.min;
            max = ri.max;

        } else if (li != null && ri == null &&
                li.root == root.left && li.max < root.val) {
            leftBstSize = li.size;
            rightBstSize = 0;
            min = li.min;

        } else if (li == null && ri != null &&
                ri.root == root.right && root.val < ri.min) {
            leftBstSize = 0;
            rightBstSize = ri.size;
            max = ri.max;

        } else if (li == null && ri == null) {
            leftBstSize = 0;
            rightBstSize = 0;
        }

        if (leftBstSize >= 0 && rightBstSize >= 0) {
            return new Info(root, leftBstSize + rightBstSize + 1, min, max);
        }

        if (li != null && ri != null) {
            return li.size > ri.size ? li : ri;
        }
        return (li != null) ? li : ri;
    }

    /**
     * 2 自底向上
     * @param root
     * @return
     */
    public int largestBSTSubtree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getInfo(root).size;
    }



    /**
     * 1 自顶向下 计算
     * @param root
     * @return
     */
    public int largestBSTSubtree1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return countOfNode(root);
        }
        int left = largestBSTSubtree1(root.left);
        int right = largestBSTSubtree1(root.right);
        return Math.max(left, right);
    }

    private boolean valid(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return valid(root.left, left, root.val) && valid(root.right, root.val, right);
    }

    private int countOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return countOfNode(node.left) + countOfNode(node.right) + 1;
    }
}
