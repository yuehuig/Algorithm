package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列 {

    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        boolean[] used = new boolean[nums.length];
        int[] levelList = new int[nums.length];
        dfs(0, nums, used, levelList);
        return list;
    }

    private void dfs(int idx, int[] nums, boolean[] used, int[] levelList) {
        if (idx == nums.length) {
            List<Integer> nList = new ArrayList<>();
            for (int num : levelList) {
                nList.add(num);
            }
            list.add(nList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            levelList[idx] = nums[i];
            dfs(idx + 1, nums, used, levelList);
            used[i] = false;
        }
    }
}
