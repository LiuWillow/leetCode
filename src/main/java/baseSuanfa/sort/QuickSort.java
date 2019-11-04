package baseSuanfa.sort;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/15 17:32
 * @description 快排
 * 定义最左边的为中间值M，将剩余值从L和R开始遍历，L > M或 R < M的时候，L R交换，直到L >= R，记录L的下标，交换L和M
 * 将L作为中间值，L的下标切分为两份，两边递归
 */
public class QuickSort {
    public static int partition(int[] array, int lo, int hi) {
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[lo] = key;
        return lo;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34, 4, 6, 7, 3, 35, 2, 3, 55, 2, 34, 53};
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}