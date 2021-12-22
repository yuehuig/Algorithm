package 数组;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */
public class _283_移动零 {

    /**
     * 2 赋值0 无需交换
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int cur = 0, move = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // 判断cur 与 i是否相等
            if (cur != i) {
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++;
        }
    }

    /**
     * 1 交换的方式
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int cur = 0, move = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            swap(nums, cur++, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
