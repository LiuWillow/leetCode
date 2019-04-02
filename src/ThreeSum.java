import java.util.*;

/**
 * @author lwl
 * @date 2019/3/28 18:04
 * @description 15. 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //nums[i]表示相加后的值的负数
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumMe(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i + 1]){
                int l = i + 1;
                int r = nums.length - 1;
                int sum = -nums[i];
                while (r > l){
                    if (nums[r] + nums[l] == sum){
                        result.add(Arrays.asList(-sum, nums[l], nums[r]));
                        while (nums[r] == nums[r - 1]) r--;
                        while (nums[l] == nums[l + 1]) l++;
                        r--;
                        l++;
                    }else if (nums[r] + nums[l] > sum){
                        while (nums[r] == nums[r - 1]) r--;
                        r--;
                    }else {
                        while (nums[l] == nums[l + 1]) l++;
                        r++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}