package dfs;

import java.util.*;

/**
 * @author liuweilong
 * @date 2021/4/26
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Q40_combinationSum2 {
    List<int[]> distinctRecords = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    /**
     * 官方题解
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2_Official(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = distinctRecords.size();
            if (distinctRecords.isEmpty() || num != distinctRecords.get(size - 1)[0]) {
                distinctRecords.add(new int[]{num, 1});
            } else {
                ++distinctRecords.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return result;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (pos == distinctRecords.size() || rest < distinctRecords.get(pos)[0]) {
            return;
        }

        int currentNum = distinctRecords.get(pos)[0];
        //出现次数
        int showTimes = distinctRecords.get(pos)[1];
        int currentNumMostSelectTimes = Math.min(rest / currentNum, showTimes);
        for (int selectTimes = 1; selectTimes <= currentNumMostSelectTimes; ++selectTimes) {
            tmp.add(currentNum);
            dfs(pos + 1, rest - selectTimes * currentNum);
        }
        for (int selectTimes = 1; selectTimes <= currentNumMostSelectTimes; ++selectTimes) {
            tmp.remove(tmp.size() - 1);
        }

        //不选择当前数
        dfs(pos + 1, rest);
    }


    /**
     * 模仿官方解法写一下看看
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2_tryOfficial(int[] candidates, int target) {
        if (candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<Pair> distinctNums = new ArrayList<>();
        // 记录每个数字出现次数到map
        for (int candidate : candidates) {
            if (distinctNums.isEmpty() || distinctNums.get(distinctNums.size() - 1).num != candidate) {
                Pair pair = new Pair();
                pair.num = candidate;
                pair.times = 1;
                distinctNums.add(pair);
            } else {
                distinctNums.get(distinctNums.size() - 1).times++;
            }
        }

        dfs_tryOfficial(distinctNums, target, 0);
        return result;
    }

    private static class Pair {
        private int num;
        private int times;
    }

    private void dfs_tryOfficial(List<Pair> distinctNums, int target, int curIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (curIndex == distinctNums.size()) {
            return;
        }


        Pair currentPair = distinctNums.get(curIndex);
        int times = currentPair.times;
        int currentNum = currentPair.num;
        int maxTimes = Math.min(times, target / currentNum); //剪枝
        //重复的数字统一处理
        for (int i = 1; i <= maxTimes; i++) {
            tmp.add(currentNum);
            dfs_tryOfficial(distinctNums, target - (i * currentNum), curIndex + 1);
        }

        //把上面填充的重复数字全部去掉
        for (int i = 0; i < maxTimes; i++) {
            tmp.remove(tmp.size() - 1);
        }

        // 最后是直接跳过
        dfs_tryOfficial(distinctNums, target, curIndex + 1);
    }


    /**
     * 不做distinct统计的题解
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs_2(candidates, target, 0);
        return result;
    }

    private void dfs_2(int[] candidates, int target, int curIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        //画个图就懂了
        for (int i = curIndex; i < candidates.length; i++) {
            int currentNum = candidates[i];
            if (target - currentNum < 0) {
                break;
            }

            if (i > curIndex && currentNum == candidates[i - 1]) {
                //重复剪枝
                continue;
            }

            tmp.add(currentNum);
            dfs_2(candidates, target - currentNum, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] ints = {10, 1, 2, 7, 6, 1, 5};
        //1, 2, 5, 6, 7, 10
        //2
        System.out.println(new Q40_combinationSum2().combinationSum2_2(ints, 8));
    }
}