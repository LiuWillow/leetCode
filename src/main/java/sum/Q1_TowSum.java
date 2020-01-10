package sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * author liuweilong
 * date 2020/1/9 6:14 下午
 * desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Q1_TowSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int indexValue = target - currentValue;
            Integer targetIndex = numsMap.get(indexValue);
            if (targetIndex != null) {
                return new int[]{i, targetIndex};
            }
            numsMap.put(currentValue, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = new Q1_TowSum().twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
