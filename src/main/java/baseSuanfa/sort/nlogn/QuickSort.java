package baseSuanfa.sort.nlogn;

import util.ArraysUtils;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/15 17:32
 * @description 快排
 * 定义最左边的为中间值M，将剩余值从L和R开始遍历，L > M或 R < M的时候，L R交换，直到L >= R，记录L的下标，交换L和M
 * 将L作为中间值，L的下标切分为两份，两边递归
 */
public class QuickSort {
    public int patrition(int[] nums, int lo, int hi) {
        int beginIndex = lo;
        int target = nums[lo];
        // 遍历lo + 1 到hi，跟target比较，大的换到最后，hi--，小的换到前面lo++
        // 结束条件lo >= hi
        //最后判断lo和beginIndex的大小，把交换后的beginIndex返回
        while (lo < hi) {
            if (nums[lo] <= target) {
                lo++;
            } else if (nums[lo] > target) {
                ArraysUtils.exchange(lo, hi, nums);
                hi--;
            }
        }

        if (nums[lo] < nums[beginIndex]) {
            ArraysUtils.exchange(lo, beginIndex, nums);
            return lo;
        }
        return beginIndex;
    }

    public void testSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = patrition(nums, lo, hi);
        testSort(nums, lo, mid - 1);
        testSort(nums, mid + 1, hi);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34, 4, 6, 7, 3, 35, 2, 3, 55, 2, 34, 53};
        new QuickSort().testSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void sortDiedai(int[] nums) {
        //
    }
}