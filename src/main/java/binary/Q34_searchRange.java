package binary;

import java.util.Arrays;

/**
 * @author liuweilong
 * @date 2021/3/30
 * @description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class Q34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target);
        if (i == -1) {
            return new int[]{-1, -1};
        }
        int begin = getBegin(nums, i, target);
        int end = getEnd(nums, i, target);
        return new int[]{begin, end};
    }

    private int getBegin(int[] nums, int i, int target) {
        while (--i >= 0) {
            if (nums[i] != target) {
                break;
            }
        }
        return i + 1;
    }

    private int getEnd(int[] nums, int i, int target) {
        while (++i < nums.length) {
            if (nums[i] != target) {
                break;
            }
        }
        return i - 1;
    }

    public int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println("预期 -1, -1，答案：" + Arrays.toString(new Q34_searchRange().searchRange(nums, 3)));

        int[] nums2 = new int[]{1};
        System.out.println("预期 0, 0，答案：" + Arrays.toString(new Q34_searchRange().searchRange(nums2, 1)));

        int[] nums3 = new int[]{1, 1};
        System.out.println("预期 0, 1，答案：" + Arrays.toString(new Q34_searchRange().searchRange(nums3, 1)));

        int[] nums4 = new int[]{0, 1, 1, 2};
        System.out.println("预期 1, 2，答案：" + Arrays.toString(new Q34_searchRange().searchRange(nums4, 1)));


    }
}
