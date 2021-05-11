package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 */
public class Q75_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums, nums.length, 0, result, tmp);
        return result;
    }

    private void backTrace(int[] nums, int length, int cur, List<List<Integer>> result, List<Integer> tmp) {
        if (cur == length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        backTrace(nums, length, cur + 1, result, tmp);
        tmp.remove(tmp.size() - 1);
        backTrace(nums, length, cur + 1, result, tmp);
    }
}
