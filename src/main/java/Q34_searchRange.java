/**
 * author liuweilong
 * date 2020/5/23 5:16 下午
 * desc
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        final int length = nums.length;
        final int targetIndex = binarySearch(nums, 0, length - 1, target);
        if (targetIndex == -1) {
            return new int[] {-1, -1};
        }
        final int left = getLeftIndex(nums, targetIndex - 1, target);
        final int right = getRightIndex(nums, targetIndex + 1, target, length);
        return new int[]{left, right};
    }

    public int getLeftIndex(int[] nums, int begin, int target) {
        while (begin >= 0 && target == nums[begin]) {
            begin--;
        }
        return begin + 1;
    }

    public int getRightIndex(int[] nums, int begin, int target, int length) {
        while (begin < length && target == nums[begin]) {
            begin++;
        }
        return begin - 1;
    }

    public int binarySearch(int[] nums, int lo, int hi, int target) {
        while (hi >= lo) {
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
}
