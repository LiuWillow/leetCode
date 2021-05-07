package backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/4/27
 * @description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Q46_permute {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] fetched = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>(nums.length);
        List<List<Integer>> result = new LinkedList<>();
        backTrace(nums, 0, fetched, tmp, result);
        return result;
    }

    private void backTrace(int[] nums, int fCount, boolean[] fetched, List<Integer> tmp, List<List<Integer>> result) {
        if (fCount == nums.length) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (fetched[i]) {
                continue;
            }
            int num = nums[i];
            tmp.add(num);
            fetched[i] = true;
            backTrace(nums, fCount + 1, fetched, tmp, result);
            tmp.remove(tmp.size() - 1);
            fetched[i] = false;
        }
    }

    public List<List<Integer>> permute_official(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack_official(n, output, res, 0);
        return res;
    }

    public void backtrack_official(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack_official(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permute_TryOfficial(int[] nums) {
        List<Integer> output = new ArrayList<>(nums.length);
        for (int num : nums) {
            output.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack_tryOfficial(nums.length, output, result, 0);
        return result;
    }

    public void backtrack_tryOfficial(int n, List<Integer> output, List<List<Integer>> res, int cur) {
        if (cur == n) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = cur; i < n; i++) {
            Collections.swap(output, cur, i);
            backtrack_tryOfficial(n, output, res, cur + 1);
            Collections.swap(output, cur, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q46_permute().permute(new int[]{1, 2, 3}).stream().map(list -> list.stream().map(Object::toString).reduce((a, b) -> a + ", " + b)).map(s -> "[" + s + "] \n")
                .reduce((a, b) -> a + b).toString());
    }
}
