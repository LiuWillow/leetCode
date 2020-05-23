/**
 * author liuweilong
 * date 2020/5/23 5:25 下午
 * desc
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
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
        //1、在里头，就直接返回mid
        // 3、不在里头，并且在范围外
        if (hi < 0) {
            return 0;
        }
        if (lo > nums.length - 1) {
            return nums.length;
        }
        // 2、不在里头，但是在范围内，
        return lo;
    }

    public static void main(String[] args) {
        final int[] nums = {1, 4, 5, 9, 10};
        System.out.println(new Q35_searchInsert().searchInsert(nums, 2));
        System.out.println(new Q35_searchInsert().searchInsert(nums, 7));
    }
}
