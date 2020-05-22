/**
 * author liuweilong
 * date 2020/5/22 10:24 上午
 * desc
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Q33_search {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        return shitSearch(nums, lo, hi, target);
    }

    private int shitSearch(int[] nums, int lo, int hi, int target) {
        if (lo == hi && nums[lo] == target) {
            return hi;
        }
        if (lo > hi) {
            return -1;
        }
        //正序，且在范围内，则二分查找
        if (nums[lo] < nums[hi] && nums[lo] <= target && nums[hi] >= target) {
            return binarySearch(nums, lo, hi, target);
        } else
            //倒序且在范围内，继续shit
            if (nums[lo] > nums[hi]) {
                int mid = lo + (hi - lo) / 2;
                int l = shitSearch(nums, lo, mid, target);
                int r = shitSearch(nums, mid + 1, hi, target);
                if (l != -1) {
                    return l;
                }
                return r;
            }
        return -1;
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

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Q33_search().search(nums, 4));
    }
}
