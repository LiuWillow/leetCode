import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/4/26
 * @description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Q39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        dfs(result, tempResult, candidates, 0, candidates.length, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> tempResult, int[] candidates, int cur, int n, int target) {
        // cur == n 结束
        if (cur == n) {
            return;
        }

        // 加当前数等于target，结束并纳入结果集
        int currentNum = candidates[cur];
        if (target == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        dfs(result, tempResult, candidates, cur + 1, n, target);

        int gap = target - currentNum;
        if (gap >= 0) {
            tempResult.add(currentNum);
            dfs(result, tempResult, candidates, cur, n, gap);
            tempResult.remove(tempResult.size() - 1);
        }

        //直接跳过
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q39_combinationSum q39_combinationSum = new Q39_combinationSum();
        System.out.println(q39_combinationSum.combinationSum(nums, 2));
        System.out.println(q39_combinationSum.combinationSum(nums, 3));
        System.out.println(q39_combinationSum.combinationSum(nums, 4));
        System.out.println(q39_combinationSum.combinationSum(nums, 8));
    }
}
