import java.util.Arrays;

/**
 * author liuweilong
 * date 2020/5/9 9:47 上午
 * desc
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q31_nextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 2};
        new Q31_nextPermutation().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        final int length = nums.length;
        if (length <= 1) {
            return;
        }
        int i = length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i < 0) {
            Arrays.sort(nums);
        } else {
            int j = i + 2;
            while (j < length && nums[j] > nums[i]) {
                j++;
            }
            int temp = nums[j - 1];
            nums[j - 1] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums, i + 1, length);
        }
    }
}
