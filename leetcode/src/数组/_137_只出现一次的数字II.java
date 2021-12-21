package 数组;
import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 */
public class _137_只出现一次的数字II {


    /**
     * 数组转换集合去重，求和再乘以3减去原数组的和除以2既是解
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
//        return int((3*sum(set(nums))-sum(nums))/2)
        return 0;
    }

    /**
     * 1 原始算法
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int num = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                num = entry.getKey();
                break;
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) == 1) {
//                num = map.get(nums[i]);
//                break;
//            }
//        }
        return num;
    }
}
