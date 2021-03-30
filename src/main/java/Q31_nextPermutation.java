import java.util.Arrays;

/**
 * @author liuweilong
 * @date 2021/3/30
 * @description 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 */
public class Q31_nextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int length = nums.length;
        int i;
        //找到逆序之前第一个数
        for (i = length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
        }

        //这里的第i个数是左边的较大的数
        //然后获取右边比这个数大的数
        if (i >= 0) {
            int j;
            for (j = length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    break;
                }
            }
            swap(nums, i, j);
        }
        //前后交换
        //后面的排序
        Arrays.sort(nums, i + 1, length); //这样写方便，其实可以直接翻转
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        new Q31_nextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[]{1, 2, 3};
        new Q31_nextPermutation().nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{1, 3, 2};
        new Q31_nextPermutation().nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
