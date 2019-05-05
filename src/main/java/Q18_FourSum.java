import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuweilong
 * @description
 * @date 2019/4/24 17:36
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Q18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //转化为三数之和，
        //两端开始遍历Lo，Hi，中间双指针lo hi，加起来比target大的话，lo++，否则hi++，直到lo>=hi
        //Lo++
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int outSum = target - nums[0];
            for (int j = i + 1; j < length - 2; j++) {
                //也是去重
                if (j > 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int chooseNum = nums[j];
                int lo = j + 1;
                int hi = length - 1;
                while (lo < hi){
                    int threeSum = chooseNum + nums[lo] + nums[hi];
                    if (threeSum == outSum){
                        result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                    }
                    if (threeSum > outSum){
//                        while (hi - 1 > 0 && nums[hi - 1] == nums[hi]) hi--;
                        hi--;
                    }
                    if (threeSum < outSum){
//                        while (lo + 1 < length - 1 && nums[lo + 1] == nums[lo]) lo++;
                        lo++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = new Q18_FourSum().fourSum(nums, 0);
        System.out.println(Arrays.deepToString(lists.toArray()));

    }
}
