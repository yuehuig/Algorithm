package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II {
    List<List<Integer>> list;
    int[] levelArr;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>(nums.length);
        if (nums == null || nums.length == 0) {
            return list;
        }
        levelArr = new int[nums.length];
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums);
        return list;
    }

    private void dfs(int idx, int[] nums) {
        if (idx == nums.length) {
            List<Integer> result = new ArrayList<>(levelArr.length);
            for (int res: levelArr) {
                result.add(res);
            }
            list.add(result);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (checkRepeat(idx, i, nums)) {
                continue;
            }
            levelArr[idx] = nums[i];
            used[i] = true;
            dfs(idx + 1, nums);
            used[i] = false;
        }
    }

    private boolean checkRepeat(int idx, int i, int[] nums) {
        // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
        // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        return (i > 0) && (nums[i] == nums[i - 1]) && !used[i - 1];
    }
}
