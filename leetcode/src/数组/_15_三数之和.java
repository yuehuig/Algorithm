package 数组;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * https://leetcode-cn.com/problems/3sum
 */
public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(nums.length);
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length - 3;
        for (int i = 0; i <= length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {

                if (nums[begin] + nums[end] == target) {
                    if ((begin + 1 < end) && (nums[begin + 1] == nums[begin])) {
                        begin++;
                        continue;
                    } else if (end - 1 > begin && (nums[end - 1] == nums[end])) {
                        end--;
                        continue;
                    }
                    List<Integer> nList = new ArrayList<>(3);
                    nList.add(nums[i]);
                    nList.add(nums[begin]);
                    nList.add(nums[end]);
                    list.add(nList);
                    begin++;
                } else if (nums[begin] + nums[end] > target) {
                    end--;
                } else {
                    begin++;
                }
            }
        }
        return list;
    }
}
