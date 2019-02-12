import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwl
 * @date 2019/2/12 15:16
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSumSolution {
    /**
     * 暴力方法，时间复杂度O(n^2)，空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumViolence(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * 哈希表的方式，时间复杂度O(n)，空间复杂度O(n)
     */
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumSolution().twoSumMap(new int[]{3, 3}, 6)));
    }
}