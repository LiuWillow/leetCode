package backtrace;

import util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Q90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, nums.length, 0, result, tmp);
        return result;
    }

    private void dfs(int[] nums, int length, int cur, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));

        for (int i = cur; i < length; i++) {
            if (i > cur && nums[i] == nums[i -1]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, length, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Q90_subsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}).forEach(Lists::print);
    }
}
