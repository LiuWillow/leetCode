package baseSuanfa.search;

/**
 * author liuweilong
 * date 2019/11/4 11:03
 * desc
 */
public class BinarySearch {
    /**
     * 普通二分搜索
     */
    public int commonSearch(int target, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = -1;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            }
            hi = mid - 1;
            if (lo > hi) {
                return -1;
            }
        }
        return mid;
    }

    /**
     * 查找第一个值等于给定值的元素
     */
    public int firstHitSearch(int target, int[] nums) {
        int commonMid = commonSearch(target, nums);
        if (commonMid < 1) {
            return commonMid;
        }
        while (true) {
            if (--commonMid < 0) {
                return commonMid + 1;
            }
            if (nums[commonMid] != target) {
                return commonMid + 1;
            }
        }
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public int lastHitSearch(int target, int[] nums) {
        int commonMid = commonSearch(target, nums);
        if (commonMid < 1) {
            return commonMid;
        }
        int maxIndex = nums.length - 1;
        while (true) {
            if (++commonMid > maxIndex) {
                return commonMid - 1;
            }
            if (nums[commonMid] != target) {
                return commonMid - 1;
            }
        }
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public int firstBiggerSearch(int target, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public int firstSmallerSearch(int target, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] <= target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new BinarySearch().firstSmallerSearch(1, new int[]{2}));
        System.out.println(new BinarySearch().firstSmallerSearch(1, new int[]{0, 2, 2, 2, 3}));
        System.out.println(new BinarySearch().firstSmallerSearch(1, new int[]{0, 0, 4, 5}));
    }
}