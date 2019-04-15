import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/15 16:59
 * @description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Q16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //先从0遍历
        //内层设置一个L 一个R   三个数加起来，如果大于target，R--，小于的话L++，等于的话肯定是这个值
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }
}