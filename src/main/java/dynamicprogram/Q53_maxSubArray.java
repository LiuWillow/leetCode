package dynamicprogram;

/**
 * @author liuweilong
 * @date 2021/5/10
 * @description
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 */
public class Q53_maxSubArray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums[0];
        }
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < length; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Q53_maxSubArray().maxSubArray(nums));
    }
}
