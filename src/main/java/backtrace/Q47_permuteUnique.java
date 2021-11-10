package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/7
 * @description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class Q47_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        // 2 2 3 3 3 4
        List<Integer> tmp = new ArrayList<>(nums.length);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] via = new boolean[nums.length];
        backTrack(nums, tmp, result, via, 0);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> tmp, List<List<Integer>> result, boolean[] via, int cur) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //终极精华，via[i - 1]为了保证访问顺序，只有前面被访问了，后面的才访问
            if (i > 0 && nums[i] == nums[i - 1] && via[i - 1]) {
                continue;
            }
            if (via[i]) {
                continue;
            }
            tmp.add(nums[i]);
            via[i] = true;
            backTrack(nums, tmp, result, via, cur + 1);
            tmp.remove(cur);
            via[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3};
        List<List<Integer>> lists = new Q47_permuteUnique().permuteUnique(nums);
        lists.stream().map(subList -> subList.stream().map(Object::toString).reduce((a, b) -> a + ", " + b))
                .forEach(s -> System.out.println(s.get()));
    }
}
