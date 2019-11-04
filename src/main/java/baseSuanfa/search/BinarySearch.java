package baseSuanfa.search;

/**
 * author liuweilong
 * date 2019/11/4 11:03
 * desc
 */
public class BinarySearch {
    public int commonSearch(int target, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) >> 1;
            if (target == nums[mid]){
                return mid;
            }
            if (target > nums[mid]){
                lo = mid + 1;
            }
            hi = mid - 1;
            if (lo > hi){
                return -1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().commonSearch(1, new int[]{1}));
        System.out.println(new BinarySearch().commonSearch(1, new int[]{1, 2, 3}));
        System.out.println(new BinarySearch().commonSearch(1, new int[]{0, 0, 4, 5}));
    }
}