package baseSuanfa.sort;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/3 17:41
 * @description 两个合成一个，需要将数组复制到新的数组中
 */
public class GuibingSort {
    public void sort(int[] nums) {
        int length = nums.length;
        //化成两坨，传入l, r, nums,
        //merge是重点，要传入l, r, mid, nums, copy
        int lo = 0;
        int hi = length - 1;
        int[] copy = new int[nums.length];
        sort(lo, hi, nums, copy);
    }

    private void sort(int lo, int hi, int[] nums, int[] copy) {
        if (hi <= lo) {
            return;
        }
        //这里会一直递归，直到lo和hi的间隔为1，即两两比较，然后一一合并
        int mid = lo + (hi - lo) / 2;
        sort(lo, mid, nums, copy);
        sort(mid + 1, hi, nums, copy);
        merge(lo, hi, mid, nums, copy);
    }

    private void merge(int lo, int hi, int mid, int[] nums, int[] copy) {
        System.arraycopy(nums, lo, copy, lo, hi - lo + 1);
        int i = lo;
        int j = mid + 1;
        //判断左边是否用完、右边是否用完，然后判断大小
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = copy[j++];
            } else if (j > hi) {
                nums[k] = copy[i++];
            } else if (copy[i] > copy[j]) {
                nums[k] = copy[j++];
            } else {
                nums[k] = copy[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34, 4, 6, 7, 3, 2, 3, 55, 2, 34, 53};
        new GuibingSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}