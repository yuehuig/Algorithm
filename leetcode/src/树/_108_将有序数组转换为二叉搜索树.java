package 树;

public class _108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        return sortToBST(nums, 0, nums.length);
    }

    public TreeNode sortToBST(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        int mid = begin + ((end - begin) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortToBST(nums, begin, mid);
        root.right = sortToBST(nums, mid + 1, end);
        return root;
    }
}
