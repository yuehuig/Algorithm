package 树;

/**
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class _面试题_04_02_最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortToBST(int[] nums, Integer begin, Integer end) {
        if (begin > end) {
            return null;
        }
        Integer mid = begin + ((end - begin) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortToBST(nums, begin, mid - 1);
        root.right = sortToBST(nums, mid + 1, end);
        return root;
    }
}
